public interface InterfaceForThirdPartyObject {
    void thirdPartyMethodCall();
}

public class ThirdPartyObjectAdapter implements InterfaceForThirdPartyObject {
    private final ThirdPartyObject delegate;

    public ThirdPartyObjectAdapter(ThirdPartyObject delegate) {
        this.delegate = delegate;
    }

    public void thirdPartyMethodCall() {
        delegate.thirdPartyMethodCall();
    }
}

// your actual plugin implementation, not directly exposed to the main app
public class MyPlugin {
    public PerSpecResponseObject myPluginFunction(InterfaceForThirdPartyObject iUseThis){
        // this will contain your actual logic that you want to test
    }
}

// this is the plugin as exposed to the main app
public class MyPluginAdapter implements PluginInterface {
    private final MyPlugin delegate = new MyPlugin();

    // this is called by the main application
    public PerSpecResponseObject myPluginFunction(ThirdPartyObject iUseThis) {
        delegate.myPluginFunction(new ThirdPartyObjectAdapter(iUseThis));
    }
}