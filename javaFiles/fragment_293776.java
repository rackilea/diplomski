@Transactional("global")
public class SomeService {

    public void methodThatUsesTheGlobalTxManager() {
        // ...
    }

    @Transactional("special")
    public void methodThatUsesTheSpecialTxManager() {
        // ...
    }        
}