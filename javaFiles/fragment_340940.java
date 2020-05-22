public class Ussd {

    private static Logger logger = LogManager.getLogger(Ussd.class);
    private  static  String query;

    public static void ussdMessages(RoutingContext routingContext){
        String codeService = routingContext.getBodyAsJson().getString("codeService");
        getServiceQuery(codeService).setHandler(r -> {
                System.out.println("query : "+r.result());
            });
    }

    public static Future<String> getServiceQuery(String codeService){
        Future<String> future = Future.future();
        JsonObject params = new JsonObject();
        params.put("QUERY", Queries.DB_SELECT_SERVICE_QUERY);
        params.put("PARAMS", new JsonArray().add(codeService));
        System.out.println(params);
        DB.select(params, res -> {
            if (res.succeeded()) {
               query = res.result().getJsonArray("results").getJsonArray(0).getString(0);
                System.out.println(query);
                future.complete(query);
            } else {
                future.fail(res.cause().getMessage());
            }
        });
        return future;
    }
}