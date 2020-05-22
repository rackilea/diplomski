@Component
public class StringToRoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public Role convert(String id) {
        Role role = roleService.findById(Integer.valueOf(id));

        return role;
    }

}