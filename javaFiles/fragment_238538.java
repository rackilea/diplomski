rabbitTemplate.convertAndSend(exchangeNameOut, message.getString(PERSISTENCE_MESSAGE_ROUTING_KEY),
                message.getString(PERSISTENCE_MESSAGE_BODY), 
    m -> {
        m.getMessageProperties().setCorrelationIdString(""+analyticRuntime.getId());
        return m;
    });