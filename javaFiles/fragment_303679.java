Disjunction programRoles = Restrictions.disjunction();
programRoles.add(Restrictions.eq(Role.ROLE_CREATOR, user));
programRoles.add(Restrictions.eq(Role.ROLE_AUTHORIZER, user));
programRoles.add(Restrictions.eq(Role.ROLE_CONTACT, user));

// change starts here
if(roleManagerService.isAdmin()) {
    Conjunction notHiddenStateForAdmin = Restrictions.conjunction();
    notHiddenStateForAdmin.add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.FIRST_STATE.name()));
    notHiddenStateForAdmin.add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.SECOND_STATE.name()));
    notHiddenStateForAdmin.add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.THIRD_STATE.name()));
    programRoles.add(notHiddenStateForAdmin);
}

// rest unchanged
Criteria results = this.session.createCriteria(PurchaseRequest.class)
       .createAlias("currentState", "currentState")
       .add(programRoles);

if(!roleManagerService.isAdmin()) {
     results.add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.DEAD.name()))
            .add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.ARCHIVED.name()))
            .add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.FINAL.name()))
            .add(Restrictions.ne("currentState.prStateCode", ApplicationStateEnum.BURIED.name()));
}