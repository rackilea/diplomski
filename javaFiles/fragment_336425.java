public class User {
    @NotNull(groups = GroupUser.class)
    String firstname;
    @NotNull(groups = GroupAddress.class)
    String street;
    @NotNull(groups = GroupAddress.class)
    String city;
}