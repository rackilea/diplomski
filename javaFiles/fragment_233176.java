public interface RetrofitInterface {

@Headers({"Content-type: application/json" , "Accept: application/json"})
@Streaming
@POST("https://xxx.newtotelapps.fr:5000/device/listEvent")
Call<JSONObject> getListEvent(@Body JSONObject jsonObject);