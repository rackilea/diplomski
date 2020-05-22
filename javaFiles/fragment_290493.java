public class Main {

    public static void main(String[] args){
        new SpringApplicationBuilder(Main.class)
                .initializers(new LoggingInitializer())
                .run(args);
    }
}