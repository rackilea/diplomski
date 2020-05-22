public static final String EXAMPLE_TEST = "<12-08-1992>\n" +
                                          "<Name1><Info1><More1><><Moreagain1>\n" +
                                          "<Name2><Info2><><Morer2><Moreagain2>";

public static void main(String[] args) {
  Pattern pattern = Pattern.compile("<[a-zA-Z0-9-]*>");

  Matcher matcher = pattern.matcher(EXAMPLE_TEST);
  while (matcher.find()) {
    System.out.println(matcher.group());

    /* optionnaly  : remove <> characters and filter date
    String output = matcher.group().replaceAll("[<>]","");
    if(!output.isEmpty()) {
      //And don't display dates
      try {
        new SimpleDateFormat("dd-MM-yyyy").parse(output);
      } catch (ParseException e) {
        //Display only if the result is not a date.
        System.out.println(output);
      }
    }
    */
  }
}