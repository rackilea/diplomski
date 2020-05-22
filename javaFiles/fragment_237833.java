@Multipart
@POST("/v2/{type}/{id}/message.json")
void addMessage(@Path("type") String type,
            @Path("id") int id,
            @Part("content") String content,
            @Part("attachment[file_cache]") String fileCache,
            @Part("attachment[original]") String original,
            @Part("attachment[versions][small]") String small,
            Callback<Post> callback);