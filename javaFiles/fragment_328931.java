@Stateless
public class MyBean {
    @Resource
    ManagedExecutorService managedExecutorService;
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    Instance<MyTask> myTaskInstance;

    public void executeAsync() throws ExecutionException, InterruptedException {
    for(int i=0; i<10; i++) {
        MyTask myTask = myTaskInstance.get();
        this.managedExecutorService.submit(myTask);
    }
}