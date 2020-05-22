public static Result newPaper() {
    // Bind submitted form value to your model, ex. Paper.java
    Form<Paper> paperForm = Form.form(Paper.class).bindFromRequest();
    Paper paper = paperForm.get();

    Logger.info("Title entered = " + paper.title);
    // Because in template we use indexed name, unchecked item are binded with null value
    paper.topics.removeAll(Collections.singleton(null)); // remove value for unchecked topic
    for (String t : paper.topics) {
       Logger.info("The topic is " + t);
    }
    Logger.info("Total topic selected = " + paper.topics.size());

    return redirect(routes.Application.index()); // redirect page
}