@Mapping(source = "user.groups", target = "user.groups", qualifiedByName = "profileAndGroup")
@Mapping(source = "user.authorities", target = "user.authorities", qualifiedByName = "profileAndAuthority")
public ProfileServiceDTO profileToProfileServiceDTO(Profile profile);

@Named("profileAndGroup")
@Mapping(target = "users", expression = "java(null)")
@Mapping(target = "authorities", expression = "java(null)")
GroupServiceDTO profileAndGroup(Group group);

@Named("profileAndAuthority")
@Mapping(target = "users", expression = "java(null)")
@Mapping(target = "groups", expression = "java(null)")
AuthorityServiceDTO profileAndAuthority(Authority authority);