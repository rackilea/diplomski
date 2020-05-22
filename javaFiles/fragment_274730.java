public class ThirdPartyLib 
{
    protected static final Logger log = LogManager.getLogger("third-party-lib");
    public void doSomething()
    {
        log.debug("Third Party App is about to Do something!");
        log.info("Third Party App just did something");
    }
}