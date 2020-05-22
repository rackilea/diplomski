public static Result someAction() {
    Map<String,String[]> formData = request().body().asFormUrlEncoded();

    Institution institution;
    // get all institutionCollection select value
    for (String insId : formData.get("institutionCollection")) {
        Logger.debug("INSTITUTION SELECTED = " + insId); // log info

        // I assume that select value is the ID of each Institution record
        institution = Institution.find.byId(Long.parseLong(insId))
        SomeModel.institutionCollection.add(institution) // add to the list to your model
    }
    SomeModel.save(); // save changes
    return ok("success");
}