Message outMsg = new GenericMessage<SomeObject>(new SomeObject(1));
someChannel.send(outMsg);
GenericMessage<String> inMsg = (GenericMessage<String>) messageCollector.forChannel(someChannel).poll();
SomeObject someObject = new ObjectMapper().readValue(inMsg.getPayload(), SomeObject.class);

Assert.assertTrue(someObject instanceof SomeObject);