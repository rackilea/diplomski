public static Errors Parse(int num) {

  for(Errors error: Errors.values() ) {
     if (error.getErrorCode() == num ) {
         return error;
     }
  }
  return null;

}