@Entity
public class Dashboard {

    @Id
    private int id;
    private String name;

    public Dashboard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Dashboard() {}

}

@Entity
public class User {

    @Id
    private int id;
    private String name;
    @ElementCollection
    private Map<Dashboard, Boolean> dashboards;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.dashboards = new HashMap<Dashboard, Boolean>();
    }

    protected User() {}

    // disclaimer: the following 'business logic' is not necessarily of the finest quality

    public Set<Dashboard> getDashboards() {
        return dashboards.keySet();
    }

    public Dashboard getDefaultDashboard() {
        for (Entry<Dashboard, Boolean> dashboard : dashboards.entrySet()) {
            if (dashboard.getValue()) {
                return dashboard.getKey();
            }
        }
        return null;
    }

    public void addDashboard(Dashboard dashboard) {
        dashboards.put(dashboard, false);
    }

    public void setDefaultDashboard(Dashboard newDefaultDashboard) {
        Dashboard oldDefaultDashboard = getDefaultDashboard();
        if (oldDefaultDashboard != null) {
            dashboards.put(oldDefaultDashboard, false);
        }
        dashboards.put(newDefaultDashboard, true);
    }

}