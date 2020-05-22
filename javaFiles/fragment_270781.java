class TestUtils {

    public static void setPrivateField(Object targetObject, String fieldName,
          Object valueToSetOnThisField) {

          try {
             Field f = obj.getClass().getDeclaredField(fieldName);
             f.setAccessible(true);
             f.set(obj, valueToSet);
          } catch (Exception e) {
            // Handle the exception accordingly
          }
       }
}