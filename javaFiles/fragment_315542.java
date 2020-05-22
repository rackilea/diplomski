Genson genson = new Genson.Builder()
                            // enables polymorphic types support
                            .setWithClassMetadata(true)
                            // enables no arg support
                            .setWithDebugInfoPropertyNameResolver(true)
                          .create();

// will look like: [{"@class": "com.xxx.SomeConcreteClass", ...}, {"@class": "com.XXX.OtherClass"}]
String json = genson.serialize(getListOfAs());
List<A> listOfA = genson.deserialize(json, new GenericType<List<A>>() {});