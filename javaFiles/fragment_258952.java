import com.google.api.client.auth.oauth2.StoredCredential;

public static GoogleCredential createGoogleCredential(StoredCredential storedCredential) {
    GoogleCredential googleCredential = new GoogleCredential.Builder()
        .setTransport(new NetHttpTransport())
        .setJsonFactory(new JacksonFactory())
        .setClientSecrets("client_id", "client_secret")
        .setAccessToken(storedCredential.getAccessToken())
        .build();

    return googleCredential;
}