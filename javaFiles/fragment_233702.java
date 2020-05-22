if (rs.next) {

    // Create a new user from the result set....
    User user = createUser(rs);

    if ("admin".equals(user.getType()) {
        AdminHome ah = new AdminHome(user);
        ah.setVisible(true);
    } else {
        EmployeeHome eh = new EmployeeHome(user);
        eh.setVisible(true);
    }

}