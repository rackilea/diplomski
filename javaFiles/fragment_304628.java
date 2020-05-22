public abstract class BaseBean {

    @PostConstruct
    public void postConstruct() {
        init();
    }

    public abstract void init();

}