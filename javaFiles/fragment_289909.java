public class MainInfo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        SampleInfo si=context.getBean(SampleInfo.class);
        si.callInfo();
    }

}