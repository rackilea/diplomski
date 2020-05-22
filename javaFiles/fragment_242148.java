@Mapper
public interface UserMapper {
    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LocalUser map(LocalUserDTO userDTO);

    @InheritInverseConfiguration
    LocalUserDTO map(LocalUser user);


    List<UserDTO> map(List<User> users);

    FacebookUser map(FacebookUserDTO userDTO);

    @InheritInverseConfiguration
    FacebookUserDTO map(FacebookUser user);

    TwitterUser map(TwitterUserDTO userDTO);

    @InheritInverseConfiguration
    TwitterUserDTO map(TwitterUser user);

    default UserDTO map(User user) {

        if (user instanceof FacebookUser) {
            return this.map((FacebookUser) user);
        } else if (user instanceof TwitterUser) {
            return this.map((TwitterUser) user);
        } else {
            return this.map((LocalUser) user);
        }
    }

    @InheritInverseConfiguration
    default User map(UserDTO userDTO) {
        if (userDTO instanceof FacebookUserDTO) {
            return this.map((FacebookUserDTO) userDTO);
        } else if (userDTO instanceof TwitterUserDTO) {
            return this.map((TwitterUserDTO) userDTO);
        } else {
            return this.map((LocalUserDTO) userDTO);
        }
    }

}