Response response = given().contentType(ContentType.JSON)
        .relaxedHTTPSValidation().when().get("<URL>");

String html = response.asString();



String sessionid = response.getCookie("JSESSIONID");
 org.jsoup.nodes.Document loginDoc = Jsoup.parse(html);
 String ltTagValue = loginDoc.select("input[name=lt]").val();
 String executionTagValue = loginDoc.select("input[name=execution]").val();

HashMap<String, Object> head = new HashMap();

 head.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
 head.put("Accept","text/html");
 head.put("Accept-Language" ,"en-US,en;q=0.9");


 Response response2=   given().headers(head).

 contentType(ContentType.URLENC).cookie("CASTGC","").cookie("JSESSIONID", sessionid).
 cookie("CASPRIVACY","")
 .cookie("Path","/em-cas").
 relaxedHTTPSValidation().    
 formParam("username", "<abc>").
 formParam("password", "<xyz>").
 formParam("lt", ltTagValue).
 formParam("execution", executionTagValue).
 formParam("_eventId", "submit").
 formParam("submit", "LOGIN").

 when().
 post(<URL>)
 ;