ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(url);
connectionFactory.setTrustStore("truststore.ts");
connectionFactory.setTrustStorePassword("password");

Connection connection = connectionFactory.createConnection();
connection.start();