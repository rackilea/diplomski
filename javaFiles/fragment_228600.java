public static class GenericResponse{
      public ServerException exception;
      public StandardResponse1 responseType1;
      public StandardResponse2 responseType2;

      @Override
      public String toString() {
         return "GenericResponse [exception=" + exception + ", responseType1=" + responseType1 + ", responseType2=" + responseType2 + "]";
      }

   }

   public static class ServerException{
      public int error;
      public String message;
   }

   public static class StandardResponse1{
      public List<Integer> list;
      public Date now;
   }