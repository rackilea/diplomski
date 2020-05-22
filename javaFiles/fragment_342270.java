Properties props = new Properties();
props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "/var/private/ssl/kafka.client.truststore.jks");    
props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, resourcePath.get("keystore.jks"));
props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,  "test1234");
props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG,  "test1234"); 
props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG,  "test1234");