public class MappingRegistrar<K,V> {

   private final MappingRegistry<K,V> registry;

   private K key;
   private V value;

   @Autowired
   public MappingRegistrar(MappingRegistry<K,V> registry) {
      this.registry = registry;
   }

   public void setKey(K key) {
      this.key = key;
   }

   public void setValue(V value) {
      this.value = value;
   }

   @PostConstruct
   public void registerMapping() {
      registry.addMapping(key, value);
   }
}