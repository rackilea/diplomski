if(isOnline(this)) {
    HTTPRequest.getHTTPRequest(HTTPRequest.getPacksURL, this);
}
else{
    dialog("No internet connection available","their is limited functionality available in offline mode",1);
}