Promise<User> resultPromise = wsPromise.map(new F.Function<WS.Response, User>() {
    @Override
    public User apply(WS.Response response) throws Throwable {
        System.out.println(response.getBody());
        return Json.fromJson(response.asJson(), User.class);
    }
});