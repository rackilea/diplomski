@ManagedBean(name="userGroupBacking")
@ViewScoped
public class UserGroupBacking {

    @ManagedProperty(value="#{accessBacking}")
    private AccessBacking accessBacking;
    public void setAccessBacking(AccessBacking accessBacking) {
        this.accessBacking = accessBacking;
    }

    @PostConstruct
    public void init() {
        loadData();
    }

    // CHECKS AGAINST ACCESSBACKING
    public boolean isHasAccess() {
    return accessBacking.isHasAccess();
    }

    // CHECKS AGAINST ACCESSBACKING
    public boolean checkViewAccess() {
    return accessBacking.checkViewAccess();
    }

    /**
     * Loads the data for the page
     */
    public void loadData() {
        Dao dao = new Dao(ds);
        users = dao.findAllUsers(accessBacking.getUsername(), accessBacking.getRoles());  
    }
}