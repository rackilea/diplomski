public static BeanFactory createContext(String genericDirectoryName) {
    System.setProperty("genericDirectory", genericDirectoryName);

   AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
   applicationContext.refresh(); 
   return applicationContext;
}