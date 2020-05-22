String email = ...
String password = ...
String url = ...

PostMethod post = new PostMethod(url);

NameValuePair[] data = {
    new NameValuePair("logindetails[email]", email),
    new NameValuePair("logindetails[password]", password)
};

post.setRequestBody(data);

// execute method and handle any error responses.

HttpClient httpclient = new HttpClient();

int statusCode = httpclient.executeMethod(post);

// continue as neccessary