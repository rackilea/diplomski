public class PersistBO implements InitializingBean, DisposableBean { 
    public void destroy() {
        shutdownExecutor();
    }
    ...
}