Pattern pattern = Pattern.compile("(.*Jack)\\s*=\\s*(\\d+)(.*)");
    String testString = " Jack =154, Jill = 111";

    Matcher matcher = pattern.matcher(testString);
    if(matcher.find()) {
        System.out.println(matcher.group(2));
     }