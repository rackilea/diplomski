public class Application

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MessageHelper helper = ctx.getBean(MessageHelper.class);
        helper.sendMessage("Hello World!");
    }
}