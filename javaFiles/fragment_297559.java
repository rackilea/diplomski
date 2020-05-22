public static <T> List<String[]> GetInvalidProperties(Set<ConstraintViolation<T>> cv){
   Iterator<ConstraintViolation<T>> iterator = cv.iterator();
   while(iterator.hasNext()) {
      ConstraintViolation<T> i = iterator.next();
      String property = i.getPropertyPath().toString();
      String message = i.getMessage();
      invalidFields.add(new String[] { property, message });
   }
}