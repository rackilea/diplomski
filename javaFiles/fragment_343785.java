ObjectMapper mapper = new ObjectMapper();
SimpleModule module = new SimpleModule();
module.addDeserializer(Message.class, new MessageDeserializer());
mapper.registerModule(module);

Message readValue = mapper.readValue(json, Message.class);