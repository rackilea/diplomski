String url = "http://server.domain/what/ever/A_segment/xxxx/ref=123";
Pattern p = Pattern.compile("/A_segment/(.+)/ref=");
Matcher m = p.matcher(url);
if (m.find()){
    String result = m.group(1); //<-get match from group 1
    System.out.println(result); //Output: xxxx
} else {
    //here you can throw exception or return some default value in case of lack of match
}