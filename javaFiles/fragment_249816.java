@Override
public HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {

    //  add signin header to each request
    request.addHeader(new BasicHeader("Authorization", this.signinToken));

    HttpResponse response = httpClient.execute(request);
    if(response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
        //  do the authentication process again
        this.signinToken = SigninTokenProvider.getToken();
        request.removeHeader("Authorization");
        request.addHeader(new BasicHeader("Authorization", this.signinToken));

        //  resend the request
        response = httpClient.execute(request);
    }

    return response;
}