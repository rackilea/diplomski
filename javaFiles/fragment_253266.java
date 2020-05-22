RestAdapter restAdapter = new RestAdapter.Builder()
                   .setEndpoint(BuildConfig.IP)
                    .setConverter(new GsonConverter(new GsonBuilder()
                            .registerTypeAdapter(Explorer.class, new ExplorerDeserializerJson())
                            .create()))
                    .build();
            restAdapter.create(CenterClient.class).getCenter(1);