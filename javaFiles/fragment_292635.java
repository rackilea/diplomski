String s="stackoverflow " +
            "http://naishe.blogspot.com " +
            "http://tw.com/#!/someTEXTs  " +
            "http://ts123t1.rapi.com/#!download|13321|1313|fairy_tale.mp4 " +
            "http://www.google.com/ " +
            "https://www.google.com/. " +
            "google.com " +
            "google.com, " +
            "google.com/test " +
            "123.com/test " +
            "ex-ample.com " +
            "http://ex-ample.com/test-url_chars?param1=val1&;par2=val+with%20spaces " +
            "something else";
    Pattern trimmer = Pattern.compile("(?:\\b(?:http|ftp|www\\.)\\S+\\b)|(?:\\b\\S+\\.com\\S*\\b)");
    Matcher m = trimmer.matcher(s);
    StringBuffer out = new StringBuffer();
    int i = 1;
    System.out.println(trimmer.toString());
    while(m.find()){
        System.out.println("|"+m.group()+"|");
    m.appendReplacement(out, "<a href=\""+m.group()+"\">URL"+ i++ +"</a>");
}
m.appendTail(out);
System.out.println(out+"!");