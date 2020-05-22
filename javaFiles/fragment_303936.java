@Extension
public class Plugin extends hudson.Plugin {
    private String url;
    private static Plugin INSTANCE;

    @Override
    public void configure(StaplerRequest req, JSONObject formData) throws IOException, ServletException, Descriptor.FormException {
        super.configure(req, formData);
        url = formData.getString("url");
        save();
    }

    @Override
    public void start() throws Exception {
        super.start();
        load();
        INSTANCE = Jenkins.getInstance().getPlugin(Plugin.class);
    }

    static String getUrl() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Plugin instance is not defined yet");
        }
        return INSTANCE.url;
    }
}