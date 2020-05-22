public class RedirectBehavior extends Behavior {

    private final Class<? extends Page> page;
    private final int redirectInSeconds;

    public RedirectBehavior(Class<? extends Page> page, int redirectInSeconds) {
        this.page = page;
        this.redirectInSeconds = redirectInSeconds;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        response.renderString(String.format("<meta http-equiv='refresh' content='%d;URL=%s' />", redirectInSeconds,
                RequestCycle.get().urlFor(page, null)));
    }
}