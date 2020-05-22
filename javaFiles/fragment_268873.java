public abstract class AbstractVM {

    public AbstractVM() {
        this.autowire(this);
    }

    protected final void autowire(Object object) {
        this.getApplicationContext().getAutowireCapableBeanFactory()
                .autowireBean(object);
        this.getApplicationContext().getAutowireCapableBeanFactory()
                .initializeBean(object, null);
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    protected final ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils
                .getRequiredWebApplicationContext(Executions.getCurrent()
                        .getDesktop().getWebApp().getServletContext());
    }
}