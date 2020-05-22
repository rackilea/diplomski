public User AddUser( User user ) {
// TODO Auto-generated method stub
 List<Role> roles = new ArrayList<Role>();
 for(Role entry :user.getRoles()) 
    roles.add(roleDao.findOne(entry.getId()));
user.setRoles( roles );
return userRepsitory.save( user );
}