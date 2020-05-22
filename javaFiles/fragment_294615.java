class CustomRedirectHandler extends DefaultRedirectHandler {
    public URI getLocationURI(HttpResponse response, HttpContext context) {
        // Extract the Location: header and manually convert spaces to %20's
        // Return the corrected URI
    }
}

DefaultHttpClient httpClient = new DefaultHttpClient();
RedirectHandler customRedirectHandler = new CustomRedirectHandler();
//...
httpClient.setRedirectHandler(customRedirectHandler);