private String getAccessToken() throws IOException {
    GoogleCredential googleCredential = GoogleCredential
            .fromStream(getServiceAccountInputStream())
            .createScoped(Collections.singletonList("https://www.googleapis.com/auth/firebase.messaging"));
    googleCredential.refreshToken();
    return googleCredential.getAccessToken();
}

private InputStream getServiceAccountInputStream() {
    File file = new File(serviceAccountPath);
    try {
        return new FileInputStream(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException("Couldn't find service-account.json");
    }
}