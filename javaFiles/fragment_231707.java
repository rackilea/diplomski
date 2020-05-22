String result = s.replaceAll("(?i)[aeiou]", "*");   // (?i) for case insensitive
   Pattern pattern = Pattern.compile("([a-zA-Z])");  // any character
   Matcher matcher = pattern.matcher(result);
   if(matcher.find()){
      result = matcher.replaceFirst(matcher.group(0).toUpperCase()); 
   }