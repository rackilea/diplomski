public class ClassAFactoryBean implements FactoryBean<ClassA> {

   @Value("${uris}")
   URI[] uris;

   ClassA getObject() throws Exception {
       return new ClassA(uris);
   }

   Class<T> getObjectType() {
       return ClassA.class;
   }

   boolean isSingleton() {
       return true;
   }
}