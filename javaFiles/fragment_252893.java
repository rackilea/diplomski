@Path("/allmusic")
public class GetAllMusic {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/playlist")
    public Response getAllSongs(@Context HttpHeaders httpHeaders) throws UnknownHostException {


        DB db = (new MongoClient("localhost",27017)).getDB("musicdb");
        DBCollection dbCollection = db.getCollection("catalog");
        DBCursor cursor = dbCollection.find();

        JSON json =new JSON();
        @SuppressWarnings("static-access")
        String serialize = json.serialize(cursor);
        System.out.println(serialize);

        return Response.ok(serialize, MediaType.APPLICATION_JSON).build();
    }   
}