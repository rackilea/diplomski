public class AppMain {

    @SuppressWarnings({ "unused", "resource" })
    public static void main(String args[]){
        AbstractApplicationContext  context = new AnnotationConfigApplicationContext(Requester.class);
    }

}