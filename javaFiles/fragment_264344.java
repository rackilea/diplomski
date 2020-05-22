String str = "KMMH12DE1433";
    //Make the pattern, case-insensitive using (?i)
    Pattern pattern = Pattern.compile("(?i)[a-z]{2}([0-9]{2})[a-z]{1,2}([0-9]{4})");
    //Create the Matcher
    Matcher m = pattern.matcher(str);
    //Check if we find anything
    if(m.find()) {
        //Use what you found - with proper capturing groups you 
        //gain access to parts of your pattern as needed 
        System.out.println("Found this: " + m.group());
    }