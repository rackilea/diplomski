public class Module extends AbstractModule {  
     @Override  
     protected void configure() {  
         bind(PersonManager.class).to(PersonManagerImpl.class);
     }  
 }