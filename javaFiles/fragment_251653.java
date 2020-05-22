public User updateUserDetails(User template){
    User toUpdate = EM.find(User.class,template.getId());
    Set<UserProject> present = template.getUserProjects();//the ones should be kept
    Set<UserProject> toDel = new HashSet<>(toUpdate.getUserProjects());
    toDel.removeAll(present); //the difference so the once should be removed
    Set<UserProjcet> newOnes = new HashSet<>(present);
    newOnes.removeAll(toUpdate.getUserProjects()); //freshly added
    for (UserProject uP : toDel) {
        up.getProject().getUserProjects().remove(uP); //from each project removing reference to UserProject
        toUpdate.getUserProjects().remove(uP);
        EM.remove(uP); //removing the actuall 
    }
    toUpdate.getUserProjects().addAll(newOnes);
    return toUpdate;
}