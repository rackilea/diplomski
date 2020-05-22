public void send(MqttWireMessage message, MqttToken token) throws MqttException {
        final String methodName = "send";
        if (message.isMessageIdRequired() && (message.getMessageId() == 0)) {
            message.setMessageId(getNextMessageId());
        }
        if (token != null ) {
            try {
                token.internalTok.setMessageID(message.getMessageId());
            } catch (Exception e) {
            }
        }

        /////......
    }