String pattern = "(?i)\\bCloneURLHttp:\\s*([^,]*)";
Pattern r = Pattern.compile(pattern);
Matcher m;
m = r.matcher(s);
String httpaddress = "";
if (m.find()) {
        httpaddress = m.group(1);
 }