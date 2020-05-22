Promise<User> resultPromise = wsPromise.map(new F.Function<WS.Response, User>() {
    @Override
    public User apply(WS.Response response) throws Throwable {
        System.out.println(response.getBody());
        JsonNode json = response.asJson();
        return new User(json.get("username"), json.get("email"));
    }
});