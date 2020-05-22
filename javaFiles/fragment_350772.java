@Component
@Log4j2
public class HibernateEventListener implements PostCommitDeleteEventListener {

@Autowired
@Qualifier("hibernateOneERPSessionFactory")
private SessionFactory sessionFactory;

@Autowired
private ThreadPoolTaskExecutor taskExecutor;

@Autowired
private TranslationDAO translationDAO;

@PostConstruct
public void registerListeners() {

    taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
    taskExecutor.setAwaitTerminationSeconds(Integer.MAX_VALUE); 

   final EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory)
            .getServiceRegistry().getService(EventListenerRegistry.class);
    registry.appendListeners(EventType.POST_COMMIT_DELETE, this);
}

@Override
public void onPostDelete(PostDeleteEvent event) {
    Object obj = event.getEntity();
    if(obj instanceof Translateable) {
        Translateable translateable = (Translateable)obj;
        if (translateable.hasTranslation()) {
            Runnable task = new Runnable() {
                 public void run()  {
                    translationDAO.deleteUnusedTranslations();
                 }
            };
            taskExecutor.initialize();
            taskExecutor.execute(task);
            taskExecutor.shutdown();
        }
    }
}
}