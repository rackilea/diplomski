public class Application implements javax.servlet.ServletContextListener {

    private static final transient Logger log = LoggerFactory.getLogger(Startup.class);

    private Map<String, User> users = new HashMap<>();
    private UserRolesDb userRolesDb = new UserRolesDb("localhost:4412");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Code here is executed on application startup
        userRolesDb.connect();
        for(User user: validateResult(userRolesDb.getAll()) ) {
            users.put(user.getId(), user);
        }
    }

    public getUserRoles(){
        return Collections.unmodifiableMap(users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Code here is executed on application close
        throw new UnsupportedOperationException("Not supported yet.");
    }
}