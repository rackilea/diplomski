void myFunction(HttpRequestBase request) {
    ...
}

...
HttpGet getRequest = new HttpGet();
myFunction(getRequest);  // No need to cast