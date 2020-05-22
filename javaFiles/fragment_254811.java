public interface PlatformDependentLogic {
    void platformInstructions();
}

@Component @Profile("dev")
public class DevLogic implements PlatformDependentLogic {
    public void platformInstructions() {
        your();
        certain();
        instructions();
    }
}
@Component @Profile("!dev")
public class NoopLogic implements PlatformDependentLogic {
    public void platformInstructions() {
        // noop
    }
}