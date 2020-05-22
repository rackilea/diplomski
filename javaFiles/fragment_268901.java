String getPropertySafely(String key) {
   try {
      return getProperty(key);
   } catch (Exception e) {
      return null;
   }
}