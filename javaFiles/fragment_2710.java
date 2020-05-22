PostMethod post = new PostMethod("http://localhost:8118/log.srv");
post.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");
NameValuePair[] data = {
  new NameValuePair("action", "likearticle"),
  new NameValuePair("noname", "989858"),
  new NameValuePair("ladoi", "cutymaraton")
};
post.setRequestBody(data);    

HttpClient httpclient = new HttpClient();
int result = httpclient.executeMethod(post);

InputStream in = post.getResponseBodyAsStream();
// handle response.