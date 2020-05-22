Pattern p = Pattern.compile("\"([^\\\"]*)\"\\s*=\\s*\\(([^\\)]*)\\)*.");
   // put p as a class member so it's computed only once...

   String stringToMatch = "\"http://123.45\" = (0,1,3)";
   // the string to match - hardcoded here, but you will probably read 
   // this from a file or similar
   Matcher m = p.matches(stringToMatch);
   if (m.matches()) {
      String url = p.group(1);    // what's between quotes
      String value = p.group(2);   // what's between parentheses
      System.out.println("url: "+url);   // http://123.45
      System.out.println("value: "+value); // 0,1,3
   }