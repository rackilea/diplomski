public class AccountResourceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AccountService.class);

        ResourceClassHelper.getResourceClasses().forEach(this::bind);
    }
}