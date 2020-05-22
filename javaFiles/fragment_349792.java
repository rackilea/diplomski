public List<UserHasRoles> getUserHasRolesList(User us){

    us = em.merge(us);      //here i re-attached entity

    return us.getUserHasRolesList();
}