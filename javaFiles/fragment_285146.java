@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping
    UserDTO userEntityToUserDTO(UserEntity user); 
}

UserDTO userDto = UserMapper.INSTANCE.userEntityToUserDTO(userEntity);