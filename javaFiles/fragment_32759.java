static String json = "{\"id\":2,\"result\":{\"FirstWorld\":{\"FirstValue\":5,\"SecondValue\":6},\"SecondWorld\":{\"FirstValue\":5,\"SecondValue\":6}},\"error\":null}";

    public static void main(String[] args) {


        Gson g= new Gson();
        Response b=g.fromJson(json, Response.class );
        System.out.println(g.toJson(b));
    }