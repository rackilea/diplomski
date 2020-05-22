Pattern p = new Pattern("(/{0,2})([^/]+)");
Matcher m = p.matcher(str);
while(m.find()) {
   String token     = m.group(2);
   String delimiter = m.group(1); // (preceding delimiter. may be null)
   /*
    * ...
    */
}