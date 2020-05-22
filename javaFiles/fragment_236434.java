PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new 
PoolingHttpClientConnectionManager(RegistryBuilder
            .create()
            .register("http", PlainConnectionSocketFactory.getSocketFactory())
            .register("https", SSLConnectionSocketFactory.getSystemSocketFactory())
            .build());