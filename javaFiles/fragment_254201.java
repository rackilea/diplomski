public static Result newPaper() {
    // Bind submitted form value to your model, ex. Paper.java
    Form<Paper> paperForm = Form.form(Paper.class).bindFromRequest();
    Paper paper = paperForm.get();

    // get request value from submitted form
    Map<String, String[]> map = request().body().asFormUrlEncoded();
    String[] checkedVal = map.get("topic"); // get selected topics

    // assign checked value to model
    paper.topics = Arrays.asList(checkedVal);

    // for debugging purpose
    for (String t : paper.topics) {
        Logger.info("The topic is " + t);
    }
    Logger.info("Total topic selected = " + paper.topics.size());

    return redirect(routes.Application.index()); // redirect page
}