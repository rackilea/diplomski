public class Config {

    private Properties config;

    public Config() {
        config = new Properties();
        reloadConfig();
    }

    public Properties getConfig(){
        reloadConfig();
        return config;
    }

    public String getProperty(String key){
        return getConfig().getProperty(key);
    }

    public void reloadConfig() {

            try {
                config.load(getClass().getResourceAsStream("/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}