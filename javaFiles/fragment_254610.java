public class SwitchingAuthenticationProvider implements AuthenticationProvider
{
    ....
    public List<AuthenticationProvider> getProviders() { return delegateList; }
    public void setProviders(List<AuthenticationProvider> providers) {
        this.delegateList = providers;
    }
    ....
}