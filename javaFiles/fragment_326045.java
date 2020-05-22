@BodyParser.Of(BodyParser.Json.class)
public Result create() {
    RequestBody body = request().body();
    User user = // some logic here
    return ok(body.asJson());
}