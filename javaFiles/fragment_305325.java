String field_name = "start";
while (field_name.equals("start")) {
    try {
        Thread.sleep(500);
    } catch (InterruptedException ignore) {
    }
    Response response = when().get("my url").then().extract().response();
    field_name = response.jsonPath().getString("path.to.field_name");
}