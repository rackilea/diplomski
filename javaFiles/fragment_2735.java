@Multipart
@POST("api/myphotoupload")
Call<JsonObject> requestUpload(@Header("Authorization") String headerToken,
                                @Part MultipartBody.Part postImagesZero,
                                @Part MultipartBody.Part postImagesOne,
                                @Part MultipartBody.Part postImagesTwo,
                                @Part MultipartBody.Part postImagesThree);