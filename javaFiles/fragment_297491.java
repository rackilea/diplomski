@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SomeService {

    @Autowired
    private ApplicationContext applicationContext;

    private SomeService  getSpringProxy() {
        return applicationContext.getBean(this.getClass());
    }

    private void doSomeAndThenMore() {
        // instead of
        // this.doSometingPublicly();
        // do the following to run in transaction
        getSpringProxy().doSometingPublicly();
    }

    public void doSometingPublicly() {
        //do some transactional stuff here
    }

}