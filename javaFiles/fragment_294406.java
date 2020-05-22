public static Result putQuestionToAssignment() {
    // get all HTTP request value from submitted form
    Map<String, String[]> map = request().body().asFormUrlEncoded();
    String[] allCheckedData = map.get("question_id"); // get all checked question
    ... // bind the rest of request parameter to variable if needed

    Verkefnaspurningar verkefnaspurningar;
    // Loop for each checked question
    for (String t : allCheckedData) {
        Logger.info("Checked data is " + t);
        verkefnaspurningar = new Verkefnaspurningar(); // create each data
        ... // put the rest of code for saving the model
    }

    return TODO; // still dummy. Should be redirect!
}