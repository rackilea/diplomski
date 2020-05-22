@Repository
public class UserRepository extends TimestampRepository<User> {

    public static final String USERS_BY_USERNAME_CACHE = "usersByUsername";
    public static final String USERS_BY_EMAIL_CACHE = "usersByEmail";

    public UserRepository(
            MyProperties myProperties,
            ExistTemplate existTemplate,
            Jaxb2Marshaller marshaller,
            Jaxb2Marshaller unmarshaller,
            RoleRepository roleRepository) {
        super(
                new UserEntityInformation(myProperties.getDatabase().getDbname()),
                existTemplate, marshaller, unmarshaller);
        marshaller.setAdapters(new RoleAdapter(roleRepository));
        unmarshaller.setAdapters(new RoleAdapter(roleRepository));
    }

    // more code
}