public class Example {

    @Scope("prototype")
    public static class SomePrototypeBean{

    }

    @Singleton
    public static class MySingleton{

        @Bean
        private SomePrototypeBean somePrototypeBean;

    }

    public static void main(String[] args){
       // context creation code goes here

       // singleton is created, a prototype injected
       context.getBean(MySingleton.class);
       // NOTE: the prototype injected will last for as long as MySingleton has reference
       // my singleton will exist for as long as the context has reference

       doStuff(context);
       //prototype bean created in the method above will be GCed
    }

    public static void doStuff(Context context){
        context.getBean(MyPrototypeBean.class);
        //since we literally are doing nothing with this bean, it will be 
        // marked for garbage collection
    }

}