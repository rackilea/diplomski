String url = "http://www.url.com/";
String charset = "ISO-8859-1";

String param1 = "value1";
String param2 = "value2";
String param3 = "value3";

WSRequest wsRequest = WS.url(url);
wsRequest.parameters.put("param1", param1);
wsRequest.parameters.put("param2", param2);
wsRequest.parameters.put("param3", param3);
wsRequest.headers.put("Cookie", session.get("COOKIE"));
HttpResponse wsResponse = wsRequest.post();
String responseString = wsResponse.getString(charset);