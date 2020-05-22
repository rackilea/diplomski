String str="Current score is France 0-0 Germany"; 
  Matcher matcher = Pattern.compile("France\\s+\\d+-\\d+\\s+Germany").matcher(str);

  while (matcher.find()) {
    System.out.println(matcher.group(0));
  }