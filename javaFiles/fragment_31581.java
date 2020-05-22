List<Role> hotRoles = new ArrayList<Role>();
for(Role role : roles) {
  if(...) {
    hotRoles.add(role);
    ...
  }
}
hotPartRoles = hotRoles.toArray(new Role[hotRoles.size()]);