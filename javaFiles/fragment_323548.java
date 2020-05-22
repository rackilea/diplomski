connection = createConnection(mqttCallback);

MqttConnectOptions connOpts = optionsFromModel(connectionModel);

connOpts.setSocketFactory(getSSLSocketFactory(keyStoreInputStream, keyStorePassword));

connection.addConnectionOptions(connOpts);