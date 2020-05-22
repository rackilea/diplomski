public class MyModule extends SimpleModule {
    public MyModule(DeserializationConfig deserializationConfig) {
        super("MyModule", ModuleVersion.instance.version());
        addValueInstantiator(Q.class, new MyValueInstantiator(deserializationConfig, Q.class));
        addDeserializer(Q.class, new CustomDeserializer());
    }
}