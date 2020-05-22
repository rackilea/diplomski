Pattern pattern = Pattern.compile("^(?:<([^>]+)>\s*){2}<?([^>]+)>?$");  
    Matcher matcher = pattern.matcher(text);
    if (matcher.matches()) {
       return new Triple(matcher.group(1), matcher.group(2), matcher.group(3));
    } else{
       // error handling code
    }