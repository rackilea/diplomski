try {
    response1 = Quickstart.getGmailService().users().messages().list(userId).setLabelIds(labelIds).execute();       
    return response1.getResultSizeEstimate();
} catch (com.google.api.client.auth.oauth2.TokenResponseException e) {
    e.printStackTrace();
    FileUtils.deleteDirectory(new File(CLIENT_SECRET_PATH+File.separator+"client_secrets"));
    response.sendRedirect("/dashboard"); // redirect to your oauth request URI
} catch (IOException e) {
    e.printStackTrace();
}