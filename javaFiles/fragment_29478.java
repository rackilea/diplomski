@RunWith(AndroidJUnit4::class)
class NetworkApiTest {
    var networkApi: NetworkApi? = null

    @Test
    fun testEmptyToken() {
        val future = CompletableFuture<String>()
        networkApi = NetworkApi("")
        networkApi?.getToken {
            future.complete(it)
        }
        val result = future.get(3,TimeUnit.SECONDS)
        Assert.assertThat(it, isEmptyOrNullString())
    }
}