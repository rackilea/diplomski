String xml = "whatever.your.xml.is.here";
PostMethod post = new PostMethod(strURL);     
try {
    StringRequestEntity requestEntity = new StringRequestEntity(xml);
    post.setRequestEntity(requestEntity);
....