@Override
    @Transactional
    public boolean revokeRolesFromUserAccount(User user, List<Role> userRoles) {        
        if (user == null) {
            return false;
        }
        if (userRoles == null) {
            return false;
        }   

        User newUser = null;
        newUser = (User) this.sessionFactory.getCurrentSession().load(User.class, user.getUid());   

        List<Role> newRoleList = newUser.getRoles();

        newRoleList.removeAll(userRoles);

        if(newUser.getRoles().retainAll(newRoleList)){
            if (log.isInfoEnabled()) {
                log.info("Roles revoked from the User " + user.getUsername());
            }
            this.sessionFactory.getCurrentSession().saveOrUpdate(newUser);          
            return true;
        }else{
            return false;
    }