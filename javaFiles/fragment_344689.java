@Mapper(componentModel = "spring")
public interface UserHolderMapper {

    default User toUser(UserHolder source) {
        return source == null ? null : toUser(source.getUser());
    }

    User toUser(UserDto source);
}