import org.springframework.context.ApplicationContext;

public enum ApplicationContextHolder {
    INSTANCE;

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}