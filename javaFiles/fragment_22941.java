import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

interface RetrofitDownload {
    @GET("/maven2/com/squareup/retrofit/retrofit/2.0.0-beta2/{fileName}")
    Call<ResponseBody> downloadRetrofit(@Path("fileName") String fileName);
}