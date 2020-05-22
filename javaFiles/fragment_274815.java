sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
sparkConf.set("spark.kryo.registrator", "com.test.avro.MyKryoRegistrator");

public class MyKryoRegistrator implements KryoRegistrator {

  public static class SpecificInstanceCollectionSerializer<T extends Collection> extends CollectionSerializer {
    Class<T> type;
    public SpecificInstanceCollectionSerializer(Class<T> type) {
      this.type = type;
    }

    @Override
    protected Collection create(Kryo kryo, Input input, Class<Collection> type) {
      return kryo.newInstance(this.type);
    }

    @Override
    protected Collection createCopy(Kryo kryo, Collection original) {
      return kryo.newInstance(this.type);
    }
  }


  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void registerClasses(Kryo kryo) {
    // Avro POJOs contain java.util.List which have GenericData.Array as their runtime type
    // because Kryo is not able to serialize them properly, we use this serializer for them
    kryo.register(GenericData.Array.class, new SpecificInstanceCollectionSerializer<>(ArrayList.class));
    kryo.register(YourAvroClassName.class);
  }
}