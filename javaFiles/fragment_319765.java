public Role findRole(Member member, String name) {
    List<Role> roles = member.getRoles();
    return roles.stream()
                .filter(role -> role.getName().equals(name)) // filter by role name
                .findFirst() // take first result
                .orElse(null); // else return null
}