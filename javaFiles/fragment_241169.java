public static List<FieldError> proofFields(final List<String> fieldNames, final 
       List<FieldError> errors){
         return errors.stream().filter(fieldError -> 
       fieldNames.contains(fieldError.getField())).collect(toList());
}

public static assertFieldWithError(final List<String> fieldNames, final 
       List<FieldError> errors){
      assertEquals(fieldNames.size(), foundFields.isEmpty());
      ... iterate do more detail and check ....with assertXXXX();
}

public static assertFieldWithoutError(final 
       List<FieldError> errors){
      assertTrue(foundFields.isEmpty());
}