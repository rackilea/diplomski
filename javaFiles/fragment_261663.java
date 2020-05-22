@POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response storeData(Data data) {

            String macD = data.getMac();
            int routeD = data.getRoute();
            double latD = data.getLatitude();
            double longD = data.getLongitude();

            Database db = new Database();



           //inserted by jean
        SDBean bean= new SDBean();
        bean.status = db.insertData(macD, routeD, latD, longD);
        bean.routes= db.getStopRoute(latD, longD); //return [1,9,3]

        return Response.status(bean.status).entity(bean.toJson()).build();

    }

    //inserted by jean
    public class SDBean{

          public int status;
        //@Expose 
        public ArrayList<Integer> routes;
        public String toJson(){
             //if you use jackson


    ObjectMapper mapper = new ObjectMapper(); 
    String json =null;
    try {
        json = mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {

        e.printStackTrace();
    }
      return json;

        }