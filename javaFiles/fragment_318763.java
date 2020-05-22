String urlParam  = "textToPredict="+predicaoVo;
byte[] postData  = urlParam.getBytes( StandardCharsets.UTF_8 );

int dataLength = postData.length;

postConnection.setRequestProperty( "Content-Length", Integer.toString(dataLength));

try( DataOutputStream wr = new DataOutputStream(postConnection.getOutputStream())) {
   wr.write(postData);
}