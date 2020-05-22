@Configuration
public class MySpringContext {

   @Bean(name="myMap")
   public Map<String, StaticClass> getMyMapBean() {
      // I'm not sure where you create 'm' but if that's a bean you can inject it to the class and use it.
      for (String m : myList) {
        myMap.put(m, MyStaticFactory.createObject(m));
      }
   }
}