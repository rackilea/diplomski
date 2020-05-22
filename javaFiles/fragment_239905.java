public class MyCustomMap extends HashMap {

        @Override
        public Object put(Object key, Object value) {
            if (this.containsKey(key)) {
                System.out.println("Do whatevery you want when key exists.");
                return null;
            } else {
                return super.put(key, value);
            }
        }
    }