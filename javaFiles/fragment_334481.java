Set<Principal> subjectPrincipals = subject.getPrincipals();


    //add the roles
    for (String role : userRolesList) {

         subjectPrincipals.add(new RolePrincipal(role));
    }