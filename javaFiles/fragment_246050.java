public class ConfigServiceDAO {
    public static ConfigServiceDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        public static final ConfigServiceDAO INSTANCE = 
        ApplicationContextHolder.INSTANCE.getApplicationContext().getBean(ConfigServiceDAOBuilder.class).buildConfigServiceDAO()

        private SingletonHolder() {}
    }
}