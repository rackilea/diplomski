try
{
    logger.info("Conecting to: " + conf.getServerURI() + " Mqtt Server");
    IMqttToken token = client.connect(connOpts);
    token.waitForCompletion()
    logger.info("Connected to the: "+ conf.getServerURI() + " Mqtt Server");
    client.setCallback(getCallback());
    logger.info("Subscribe to the Topic: " + this.topic);
    //Thread.sleep(1000);
    client.subscribe(this.topic,1);
    logger.info("Successful subscription to topic: " + this.topic);
}
catch(Exception me)
{
}