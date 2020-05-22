//Only if you have 30/40 properties
  class MyClass {

       private Map<String, Object> data = new ConcurrentHashMap<String,Object>();

       public void set(String fieldName, Object value) {
               data.put(fieldName, value);
       }

       public Object get(String fieldName) {
               return data.get(fieldName);
       }

   }