Pattern p = Pattern.compile("\"[^\"]*\"");
Matcher matcher = p.matcher(yourInputString);

while (matcher.find())
  {
      //do something with the match

  }