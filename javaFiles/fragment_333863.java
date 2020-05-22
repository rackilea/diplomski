Class clazz = queryResult.get(0).getClass();
 classFields = clazz.getDeclaredFields();
 data = new Object[queryResult.size()][classFields.length];
 for(Object result : queryResult) {
     int rCounter = 0;
     for(Field field : clazzFields) {
         field.setAccessible(true);
          try {
              data[lCounter][rCounter] = field.get(result);
          } catch (IllegalArgumentException e1) {
               e1.printStackTrace();
          } catch (IllegalAccessException e1) {
               e1.printStackTrace();
          }
          rCounter++;
      }
      lCounter++;
}