String myString = "<http://v4-api.prod.emailanalyst.com/v4/competitive/search?Authorization={API_KEY}&mobileReady=true&qd=between:20150101000000,20150101060000&onlyCommercial=true&hasCreative=true&page=0&per_page=100>; rel=\"first\",<http://v4-api.prod.emailanalyst.com/v4/competitive/search?Authorization={API_KEY}&mobileReady=true&qd=between:20150101000000,20150101060000&onlyCommercial=true&hasCreative=true&page=20&per_page=100>; rel=\"last\",<http://v4-api.prod.emailanalyst.com/v4/competitive/search?Authorization={API_KEY}&mobileReady=true&qd=between:20150101000000,20150101060000&onlyCommercial=true&hasCreative=true&page=1&per_page=100>; rel=\"next\"";
  try {
    Pattern regex = Pattern.compile("\"last\",(.*?)$");
    Matcher regexMatcher = regex.matcher(myString);
    if(regexMatcher.find()) {
        String next = regexMatcher.group(1);
        System.out.println(next);
    } 
   } catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
  }

//<http://v4-api.prod.emailanalyst.com/v4/competitive/search?Authorization={API_KEY}&mobileReady=true&qd=between:20150101000000,20150101060000&onlyCommercial=true&hasCreative=true&page=1&per_page=100>; rel="next"