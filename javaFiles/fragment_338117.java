public static List<CustomStackTraceElement> getCustomizedStackTrace(Throwable t) {
   List<CustomStackTraceElement> result = new ArrayList<>();

   for(StackTraceElement e : t.getStackTrace()) {
      result.add(new CustomStackTraceElement(e));
   }

   return result;
}