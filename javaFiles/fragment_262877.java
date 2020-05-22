public class AbstractSerializable<T> implements Deserialize {
        private final String className;
        private T obj;

        public AbstractSerializable(T obj) {
              this.obj = obj;
              this.className = obj.getClass().getCardinalName();
        }

        @Override
        public AbstractSerializable deserialize(ObjectMapper objectMapper) {
             String clazz = input.readNext(String.class);
             return objectMapper.readNext(Class.forName(clazz));
        }

    }