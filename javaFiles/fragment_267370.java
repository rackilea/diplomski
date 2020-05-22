@JsonDeserialize(using = UserRolesDeserializer.class)
public class UserRolesMixin extends Roles {
    @JsonValue
    @Override
    public List<RoleType> getRole() {
        return super.getRole();
    }
}