public static MusicApiInterface getApi() {
    if (sMusicApiInterface == null) {
       Gson gson = new GsonBuilder()
           .registerTypeAdapter(DiscussionViewMoreContainer.class, new ExplorerDeserializerJson())
           .create();
       RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setConverter(new GsonConverter(gson))
            .build();
       sMusicApiInterface = restAdapter.create(MusicApiInterface.class);
     }
     return sMusicApiInterface;
}