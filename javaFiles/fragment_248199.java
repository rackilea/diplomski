public class ClassnameOne implements TestInterface {

    @Inject
    private Logger log;

    // ...

    @Override
    public void doStuff() {
        // Do stuff 

        log.info("done");
    }
}