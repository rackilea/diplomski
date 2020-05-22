interface ApiService {

    @FormUrlEncoded
    @POST(ACCESS_TOKEN_PATH)
    fun getAccessToken(
            @Field("client_id") client_id: String,
            @Field("client_secret") client_secret: String,
            @Field("grant_type") grant_type: String
    ): Flowable<GetAccessToken>
}