Pattern p = Pattern.compile("\"\\d+\"");
Matcher m = p.matcher(myString);
String var = "-1";
    while (m.find()) {
        var = m.group().replace("\"", "");
    }
return Long.parseLong(var);