final GoogleCredential googleCredential = GoogleCredential
  .fromStream(Objects.requireNonNull(classloader.getResourceAsStream("Key.json")))
  .createScoped(Collections.singletonList(StorageScopes.DEVSTORAGE_FULL_CONTROL));

final com.google.api.services.storage.Storage myStorage = new com.google.api.services.storage.Storage.Builder(
      new NetHttpTransport(), new JacksonFactory(), googleCredential).build();