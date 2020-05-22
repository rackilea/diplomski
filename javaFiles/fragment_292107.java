public class Test {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new GeoJsonModule());
        mapper.registerModule(new GeoModule());
        // Our custom module
        mapper.registerModule(new GeoModuleExt());

        // Create FoodTruckEntity - 
        GeoJsonPoint geoJsonPoint = new GeoJsonPoint(10, 10);
        FoodTruckEntity foodTruck = new FoodTruckEntity();
        // set all properties fro foodTruck

        // Create GeoResult
        GeoResult<FoodTruckEntity> geoResult
                = new GeoResult<FoodTruckEntity>(foodTruck, new Distance(10,
                                                 Metrics.KILOMETERS));

        // Serialize geoResult
        String geoResultString = mapper.writeValueAsString(geoResult);
        System.out.println(geoResultString);

        JavaType type = mapper.getTypeFactory().constructParametricType(
                GeoResult.class, FoodTruckEntity.class);

        // Deserialize geoResultString
        GeoResult<FoodTruckEntity> parsedGeoResult 
                = mapper.readValue(geoResultString, type);
        System.out.println(parsedGeoResult.getDistance());
        System.out.println(parsedGeoResult.getContent().getApplicant());

        // Up to this point everything is fine. It's the deserialization of
        // `GeoResults` thats a problem.

        /*
        List<GeoResult> results = new ArrayList<GeoResult>();
        results.add(geoResult);
        results.add(geoResult);
        GeoResults geoResults = new GeoResults(results);

        String resultsString = mapper.writeValueAsString(geoResults);
        System.out.println(resultsString);


        JavaType resultType = mapper.getTypeFactory().constructParametricType(
                                       GeoResults.class, FoodTruckEntity.class);

        GeoResults<FoodTruckEntity> parsedGeoResults 
                            = mapper.readValue(resultsString, resultType);
        for (GeoResult<FoodTruckEntity> gr: parsedGeoResults) {
            System.out.println(gr.getContent().getGeoJsonPoint());
        }*/
    }
}