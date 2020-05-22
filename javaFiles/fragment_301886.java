final GoogleCredentials googleCredentials = serviceAccountCredentials
                    .createScoped(Collections.singletonList(StorageScopes.DEVSTORAGE_FULL_CONTROL));
            HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(googleCredentials);        

final com.google.api.services.storage.Storage myStorage = new com.google.api.services.storage.Storage.Builder(
                new NetHttpTransport(), new JacksonFactory(), requestInitializer).build();