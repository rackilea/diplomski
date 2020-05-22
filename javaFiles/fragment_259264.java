byte[] data = {10,10,10,10,10}; 
HttpClient httpClient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost("server url");
ByteArrayBody bab = new ByteArrayBody(data, "image.jpg");
MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
reqEntity.addPart("image", bab);

FormBodyPart bodyPart=new FormBodyPart("formVariableName", new StringBody("formValiableValue"));
reqEntity.addPart(bodyPart);
bodyPart=new FormBodyPart("formVariableName2", new StringBody("formValiableValue2"));
reqEntity.addPart(bodyPart);
bodyPart=new FormBodyPart("formVariableName3", new StringBody("formValiableValue3"));
reqEntity.addPart(bodyPart); 
postRequest.setEntity(reqEntity);
HttpResponse response = httpClient.execute(postRequest);
BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
String line = null;
while((line = in.readLine()) != null) {
    System.out.println(line);
}