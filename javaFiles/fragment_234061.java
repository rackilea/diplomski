@Path("/restaurantDetail")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public void addRestaurantDetail(RestaurantDetails restDet) {

    rBo.addRestaurantDetails(restDet);

}