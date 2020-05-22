public class RoleAdapter extends XmlAdapter<String, List<Role>> {

    protected final RoleRepository roleRepository;

    public RoleAdapter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> unmarshal(String nameList) throws Exception {
        // code using roleRepository
    }

    @Override
    public String marshal(List<Role> roles) throws Exception {
        // some code
    }
}