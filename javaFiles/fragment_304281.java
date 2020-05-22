package test;

import java.io.InputStream;

public class PropLoader {
   public static void main(String[] args) {
      try {
         final String path;
         if(args.length == 1) path = args[0].trim();
         else path = "etc/application.properties";

         final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
         if(is == null) throw new RuntimeException("Failed to load " + path + " as a resource");
         else System.out.printf("Loaded resource from path: %s\n", path);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}