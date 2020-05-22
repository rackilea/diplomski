import okhttp3.ResponseBody;
public interface ConfigsBodyRequest
{
    @GET("config.json")
    Observable<ResponseBody> getResponse();
}