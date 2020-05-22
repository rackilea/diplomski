@SerializedName("user_id")
@Expose
private String user_id;

@SerializedName("product")
@Expose
List<OneProductModel> oneProductModels;


public CartPost(String user_id, List<OneProductModel> oneProductModels) {
    this.user_id = user_id;
    this.oneProductModels = oneProductModels;
}

@POST("/api/r_etiket")
Call<Result> post_etiket(@Body modelClass);