public class Main {

    @Inject
    private Bean bean;

    public void startup(@Observes ContainerInitialized event) {
        this.bean.sayHello();
    }
}