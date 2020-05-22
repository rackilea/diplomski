public static SourceVersion latest() { 
 return RELEASE_7;
}

private static SourceVersion More ...getLatestSupported() {
       try {
           String specVersion = System.getProperty("java.specification.version");
           if ("1.7".equals(specVersion))
               return RELEASE_7;
            else if ("1.6".equals(specVersion))
                return RELEASE_6;
        } catch (SecurityException se) {}

        return RELEASE_5;
  }