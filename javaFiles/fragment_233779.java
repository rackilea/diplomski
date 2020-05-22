public static void main(String[] args) {
    IndexedCollection<User> users = new ConcurrentIndexedCollection<>();
    users.add(new User(1, "Joe"));
    users.add(new User(2, "Jane"));
    users.add(new User(3, "Jesse"));

    IndexedCollection<Role> roles = new ConcurrentIndexedCollection<>();
    roles.add(new Role(1, "CEO"));
    roles.add(new Role(2, "Manager"));
    roles.add(new Role(3, "Employee"));

    IndexedCollection<UserRole> userRoles = new ConcurrentIndexedCollection<>();
    userRoles.add(new UserRole(1, 3)); // Joe is an Employee
    userRoles.add(new UserRole(2, 2)); // Jane is a Manager
    userRoles.add(new UserRole(3, 2)); // Jesse is a Manager

    // Retrieve Users who are managers...
    Query<User> usersWhoAreManagers =
            existsIn(userRoles, User.USER_ID, UserRole.USER_ID,
                    existsIn(roles, UserRole.ROLE_ID, Role.ROLE_ID, equal(Role.ROLE_NAME, "Manager")));


    users.retrieve(usersWhoAreManagers)
            .forEach(u -> System.out.println(u.userName));
    // ..prints: Jane, Jesse
}