InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("/WEB-INF/service_key.json");

FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(in)
                    .setDatabaseUrl(".....")
                    .build();