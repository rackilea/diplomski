@Target(ElementType.FIELD)
   @Retention(RetentionPolicy.RUNTIME)
   /**
    * This Annotation should be used on boolean field to set specify whether annotation processing should be        ignored for that class
    */
   public @interface Ignore {

   }