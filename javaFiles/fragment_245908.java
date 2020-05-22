@Component
public class TenantProvider {

    private final ThreadLocal<String> databaseName;

    public TenantProvider() {
        super();
        databaseName = new ThreadLocal<>();
    }

    public String getDatabaseName() {
        return databaseName.get();
    }

    public void setDatabaseName(final String databaseName) {
        this.databaseName.set(databaseName);

    }
}