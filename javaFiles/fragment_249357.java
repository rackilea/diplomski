public static void something(User user) throws Exception {
    try {
        ObjectWriter ow = new ObjectMapper().writer();
        String json = ow.writeValueAsString(user);
        Nesting testing = new Nesting(null, "someting");
        Object object = gson.fromJson(json, Object.class);
        testing.setDetails(object);
        JsonElement something  = gson.toJsonTree(testing);
        System.out.println(something);

    } catch (Exception e) {
        throw e;
    }
}