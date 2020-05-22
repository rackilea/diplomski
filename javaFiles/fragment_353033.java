public interface ProductRestService {
    @GET("/product/****")
    Call <Product> getProduct(long id);

    @PUT("/product/****")
    Call <Product> update(long id, @Body Product product);

    @POST("/product/****")
    Call <Product> create(@Body Product product);

    @DELETE("/product/****")
    Call <Void> deleteProduct(long id);
}