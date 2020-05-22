public interface UserRoleService {
    void saveUser(UserDto userDto, RoleDto roleDto);
}

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public void saveUser(UserDto userDto, RoleDto roleDto) {
        userService.saveUser(userDto);
        roleService.saveRole(roleDto);
    }
}