public IMqttDeliveryToken publish(String topic, MqttMessage message, Object userContext, IMqttActionListener callback) throws MqttException,
            MqttPersistenceException {
        final String methodName = "publish";
        //@TRACE 111=< topic={0} message={1}userContext={1} callback={2}
        log.fine(CLASS_NAME,methodName,"111", new Object[] {topic, userContext, callback});

        //Checks if a topic is valid when publishing a message.
        MqttTopic.validate(topic, false/*wildcards NOT allowed*/);

        MqttDeliveryToken token = new MqttDeliveryToken(getClientId());
        token.setActionCallback(callback);
        token.setUserContext(userContext);
        token.setMessage(message);
        token.internalTok.setTopics(new String[] {topic});

        MqttPublish pubMsg = new MqttPublish(topic, message);
        comms.sendNoWait(pubMsg, token);

        //@TRACE 112=<
        log.fine(CLASS_NAME,methodName,"112");

        return token;
    }