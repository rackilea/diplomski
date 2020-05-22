// test.kt

...
sealed class Result<out T> {
    data class Success<T>(val data: T?) : Result<T>()
    data class Failure(val statusCode: Int?) : Result<Nothing>()
    object NetworkError : Result<Nothing>()
}

data class Bar(
    @SerializedName("foo")
    val foo: String
)

interface Service {
    @GET("bar")
    suspend fun getBar(): Result<Bar>

    @GET("bars")
    suspend fun getBars(): Result<List<Bar>>
}

abstract class CallDelegate<TIn, TOut>(
    protected val proxy: Call<TIn>
) : Call<TOut> {
    override fun execute(): Response<TOut> = throw NotImplementedError()
    override final fun enqueue(callback: Callback<TOut>) = enqueueImpl(callback)
    override final fun clone(): Call<TOut> = cloneImpl()

    override fun cancel() = proxy.cancel()
    override fun request(): Request = proxy.request()
    override fun isExecuted() = proxy.isExecuted
    override fun isCanceled() = proxy.isCanceled

    abstract fun enqueueImpl(callback: Callback<TOut>)
    abstract fun cloneImpl(): Call<TOut>
}

class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, Result<T>>(proxy) {
    override fun enqueueImpl(callback: Callback<Result<T>>) = proxy.enqueue(object: Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            val code = response.code()
            val result = if (code in 200 until 300) {
                val body = response.body()
                Result.Success(body)
            } else {
                Result.Failure(code)
            }

            callback.onResponse(this@ResultCall, Response.success(result))
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            val result = if (t is IOException) {
                Result.NetworkError
            } else {
                Result.Failure(null)
            }

            callback.onResponse(this@ResultCall, Response.success(result))
        }
    })

    override fun cloneImpl() = ResultCall(proxy.clone())
}

class ResultAdapter(
    private val type: Type
): CallAdapter<Type, Call<Result<Type>>> {
    override fun responseType() = type
    override fun adapt(call: Call<Type>): Call<Result<Type>> = ResultCall(call)
}

class MyCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ) = when (getRawType(returnType)) {
        Call::class.java -> {
            val callType = getParameterUpperBound(0, returnType as ParameterizedType)
            when (getRawType(callType)) {
                Result::class.java -> {
                    val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                    ResultAdapter(resultType)
                }
                else -> null
            }
        }
        else -> null
    }
}

/**
 * A Mock interceptor that returns a test data
 */
class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val response = when (chain.request().url().encodedPath()) {
            "/bar" -> """{"foo":"baz"}"""
            "/bars" -> """[{"foo":"baz1"},{"foo":"baz2"}]"""
            else -> throw Error("unknown request")
        }

        val mediaType = MediaType.parse("application/json")
        val responseBody = ResponseBody.create(mediaType, response)

        return okhttp3.Response.Builder()
            .protocol(Protocol.HTTP_1_0)
            .request(chain.request())
            .code(200)
            .message("")
            .body(responseBody)
            .build()
    }
}

suspend fun test() {
    val mockInterceptor = MockInterceptor()
    val mockClient = OkHttpClient.Builder()
        .addInterceptor(mockInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://mock.com/")
        .client(mockClient)
        .addCallAdapterFactory(MyCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(Service::class.java)
    val bar = service.getBar()
    val bars = service.getBars()
    ...
}
...