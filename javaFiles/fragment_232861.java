OkHttpClient okHttpClient = new OkHttpClient.Builder()
            //default timeout for not annotated requests
            .readTimeout(10000, TimeUnit.MILLISECONDS)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .writeTimeout(10000, TimeUnit.MILLISECONDS)
            .build();