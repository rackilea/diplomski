@BodyParser.Of(BodyParser.Json.class)
public Result test() {
    JsonNode json = request().body().asJson();
    Model model = Json.fromJson(json, Model.class);
    return ok();
}