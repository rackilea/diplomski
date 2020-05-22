//Declared as a member variable of HttpURLConnection
private boolean tryTransparentNTLMServer = NTLMAuthentication.supportsTransparentAuth();

//Inside of getServerAuthentication method.
PasswordAuthentication a = null;
if (!tryTransparentNTLMServer) {
    //If set to false, this will call Authenticator.requestPasswordAuthentication().
    a = privilegedRequestPasswordAuthentication(url.getHost(), addr, port, url.getProtocol(), "", scheme, url, RequestorType.SERVER);
}

/* If we are not trying transparent authentication then 
* we need to have a PasswordAuthentication instance. For
* transparent authentication (Windows only) the username 
* and password will be picked up from the current logged 
* on users credentials.
*/
if (tryTransparentNTLMServer || (!tryTransparentNTLMServer && a != null)) {
    //If set to true or if Authenticator did not return any credentials, use Windows credentials.
    //NTLMAuthentication constructor, if receives a == null will fetch current looged user credentials.
    ret = new NTLMAuthentication(false, url1, a);
}