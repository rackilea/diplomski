public interface SendMailApi {
@Headers({ACCEPT_JSON_HEADER})
@FormUrlEncoded
@POST("/messages")
void authUser(
        @Header("Authorization") String authorizationHeader,
        @Field("from") String from,
        @Field("to") String to,
        @Field("subject") String subject,
        @Field("text") String text,
        Callback<MailGunResponse> cb
);