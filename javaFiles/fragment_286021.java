String line = "This order was placed for QT3000! OK?";
  String pattern = "(.*)(\\d{2})(.*)";

  // Create a Pattern object
  Pattern r = Pattern.compile(pattern);

  // Now create matcher object.
  Matcher m = r.matcher(line);
  while(m.find( )) {
     System.out.println("Found value: " + m.group(1));
     System.out.println("Found value: " + m.group(2));
     System.out.println("Found value: " + m.group(3));
  }