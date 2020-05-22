// this defines aliases for classes, if you don't care of class names being
// serialized then just enabled type ser/deser using builder.setWithClassMetadata(true)
Genson genson = new Genson.Builder()
                            .addAlias("person", Person.class)
                            .addAlias("other", Some.class)
                           .create();

// serialize using with type information
String json = genson.serialize(object);

// deserializing to an unkown type based on the type information in the json string
genson.deserialize(json, Object.class);