@FormUrlEncoded
@POST("/oauth/token")
void getAccessToken(
    @Field("param1") String param1,
    @Field("param2") String param2,
    @Field("param3") String param3,
    Callback<Response> callback);