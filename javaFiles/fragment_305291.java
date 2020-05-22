api.getInventory(new Callback<Map<String,List<Product>>>() {
            @Override
            public void success(Map<String,List<Product>> products, Response response) {

                mInventory = products;
            }
            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG,error.getMessage());
            }
        });

public interface ProductAPI {
    @GET("/v2/get-inventory")
    public void getInventory(Callback<Map<String,List<Product>>> response);
}