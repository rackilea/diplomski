HttpPost httpPost = new HttpPost("myurl");

StringBuilder jsonBody = new StringBuilder();
jsonBody.append("{");
jsonBody.append("\"devicename\" : ").append("\"vip\"").append(",");
// Pass a valid date because on server side, you are using Date object for accepting it
jsonBody.append("\"date\" : ").append("\"2017-09-23\"").append(",");
jsonBody.append("\"latitude\" : ").append("\"vip\"").append(",");
jsonBody.append("\"longitude\" : ").append("\"vip\"");
jsonBody.append("}");

StringRequestEntity requestEntity = new StringRequestEntity(jsonBody.toString(),"application/json","UTF-8");


httpPost.setRequestEntity(requestEntity);

httpPost.setHeader("Cache-Control", "no-cache");
httpPost.setHeader("Content-type", "application/json");
httpPost.setHeader("Host", "trackertest.herokuapp.com");
// Rest code should remain same