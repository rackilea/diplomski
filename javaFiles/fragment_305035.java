@Path("country/state/{stateName}")
class CountryResouce {

    @PathParam("stateName")
    private String stateName;

    @Path("city/{cityName}")
    public CityResource city(@PathParam("cityName") String cityName) {
        State state = getStateByName(stateName);

        City city = state.getCityByName(cityName);

        return new CityResource(city);
    }

}

class CityResource {

    private City city;

    public CityResource(City city) {
        this.city = city;
    }

    @GET
    public Response get() {
        // Replace with whatever you would normally do to represent this resource
        // using the City object as needed
        return Response.ok().build();
    }
}