public class Receiver  {
    private static ArrayList<LatLong> latLongList = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeData(Data data) {

        String macD = data.getMac();
        int routeD = data.getRoute();
        float latD = data.getLatitude();
        float longD = data.getLongitude();

        latLongList.add(new LatLong(latD, longD));

        System.out.println("latLondList size: " + latLongList.size());


        Database db = new Database();
        db.insertData(macD, routeD, latD, longD);

        return Response.status(201).build();
    }
}