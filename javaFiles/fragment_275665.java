public class ExampleUI extends UI {
    private class ExampleConfiguration implements DeploymentConfiguration {
        @Override
        public int getHeartbeatInterval() {
            return 30;
        }

        @Override
        public boolean isCloseIdleSessions() {
            return true;
        }
    }

    @Override
    protected void init(VaadinRequest request) {
        getSession().setConfiguration(new ExampleConfiguration());
        ...
    }
}