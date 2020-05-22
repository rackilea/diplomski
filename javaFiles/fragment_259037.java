@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RoleService roleService;

    public void saveUSer(UserDto userDto) {
        //code to save your userDto...
        roleService.saveRole(userDto.getRoleDto());
    }
}