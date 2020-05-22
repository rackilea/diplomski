// Register the special deserializer.
InfoDeserializer deserializer = new InfoDeserializer();
SimpleModule module = new SimpleModule("PolymorphicInfoDeserializerModule", new Version(1, 0, 0, null));
module.addDeserializer(Info.class, deserializer);
mapper.registerModule(module);
factory = new JsonFactory(mapper);