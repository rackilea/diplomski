public String getStoryFromCsv(String csv) {
    StringBuilder story = new StringBuilder();
    String[] lines = csv.split("\n”);
    appendBookingWindowValidation(story, lines[0]);
    appendTravelWindowValidation(story, lines[1]);
    appendOnlinePackageValidation(story, lines);
    return story.toString();
}

private void appendBookingWindowValidation(StringBuilder story, String firstLine) {
    story.append("Then it should have booking window ");
    // extract start and end date from 'firstLine'
    // and append them to the story
}

private void appendTravelWindowValidation(StringBuilder story, String secondLine) {
    story.append("Then it should have travel window ");
    // extract start and end date from 'secondLine'
    // and append them to the story
}

private void appendOnlinePackageValidation(StringBuilder story, String[] lines) {
    story.append("And it should have online packages:\n")
         .append("| id    | type                                              |\n");
    for (int i = 2 ; i < lines.length; i++) {
      // create and append a row of the online packages table
   }
}