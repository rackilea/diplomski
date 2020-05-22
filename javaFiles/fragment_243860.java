public List<Person> getPersonsWithParentRole{
    if(role != null){
        return role.getPersonsWithThisRoleAsParentRole();
    }
}

public List<Person> getPersonsWithParentRole{
    if(parentRole != null){
        return parentRole.getPersonsWithThisRoleAsPrimaryRole();
    }
}