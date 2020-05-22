if (ques.getName().equalsIgnoreCase("options")) {
    List<Element> options = ques.getChildren("option");
    if(options.size()>2) {
        Element optionToRemove = options.get(2);
        ques.removeContent(optionToRemove);
    }
}