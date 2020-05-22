@Component
public class Logic {
    private @Autowired PlatformDependentLogic platformLogic;
    public void doIt() {
        doMoreLogic();
        platformLogic.platformInstructions();
        doWhateverYouWant();
    }
}