public class AccountResourceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AccountService.class);
        bind(AccountResource.class);
    }
}