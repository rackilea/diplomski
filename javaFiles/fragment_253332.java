String dictString= "ONE\r\nTWO\r\nTHREE";
    Pattern p = Pattern.compile("(^|\\W)TWO(\\W|$)");
    Matcher m = p.matcher(dictString);
    if(m.find()) {
        System.out.println("MATCH: " + m.group());
    }