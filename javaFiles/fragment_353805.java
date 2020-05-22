public String getAuthUrl() {
    URIBuilder b = null;
    // Removed exception handling...
    b = new URIBuilder(AUTH_URL); // http://whatever.com

    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    nvps.add(new BasicNameValuePair("client_id", getClientId()));
    nvps.add(new BasicNameValuePair("redirect_uri", redirectURL.toString()));
    nvps.add(new BasicNameValuePair("state", STATE));
    nvps.add(new BasicNameValuePair("response_type", "code"));
    nvps.add(new BasicNameValuePair("scope", "email"));
    b.setParameters(nvps);
    return b.toString();
  }