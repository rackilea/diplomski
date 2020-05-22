MessageProto.MyMessage.Builder mb = MessageProto.MyMessage.newBuilder();
mb.setDataCenter("aDC");
mb.setClientId(12);
mb.setPoolId(14);
mb.setDataCount(2);
mb.setbody("hello world");
MessageProto.MyMessage message = mb.build();