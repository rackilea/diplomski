public class RunnerFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Runner getRunner(Task task) {
        return (Runner) applicationContext.getBean(task.getClass().getSimpleName() + "Runner");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}