public static void create(JsonObject body) {
    CaseFolder caseFolder = new Gson().fromJson(body, CaseFolder.class);
    caseFolder.user = getConnectedUser();

    if(caseFolder.validateAndSave()) {
        renderJSON(
                new JSONSerializer()
                    .exclude("*.class")
                    .exclude("user")
                    .serialize(caseFolder));
    } else 
        error();
}