Matcher m = Pattern.compile("(?m)^(.*)ID#.*([\\s\\S]*)").matcher(string);                  
if (m.find()) {
    Matcher m1 = Pattern.compile("(?m)^.{" + m.group(1).length() + "}(?<!\\S)\\h{0,3}(\\S+)").matcher(m.group(2));
    if (m1.find())
        System.out.println(m1.group(1));
}