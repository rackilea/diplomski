private void submitApplication (String body, String userName) throws SMSparkManagerException {
    HttpClient client = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost(uri+"?user.name="+userName);
    try {
        request.setEntity(new StringEntity(body, ContentType.APPLICATION_XML));
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode()!=202) {
            throw new SMSparkManagerException("The application could not be submitted to Yarn, response http code "+response.getStatusLine().getStatusCode());
        }
    } catch (UnsupportedEncodingException e) {
        logger.error("The application Could not be submitted due to UnsupportedEncodingException in the provided body: "+body, e );
        throw new SMSparkManagerException("Error in submitting application to yarn");
    } catch (ClientProtocolException e) {
        logger.error("The application Could not be submitted due to ClientProtocolException", e);
        throw new SMSparkManagerException("Error in submitting application to yarn");
    } catch (IOException e) {
        logger.error("The application Could not be submitted due to IOException", e);
        throw new SMSparkManagerException("Error in submitting application to yarn");
    }
}