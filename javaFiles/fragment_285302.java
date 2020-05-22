@Override
public Predicate toPredicate(Root<User> userRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {

    switch(field){
    case USER_GROUP:
        Join<User, Group> groupJoin = userRoot.join("group");
        return cb.equal(cb.lower(groupJoin.<String> get("name")), searchCriteria);
    case USER_ROLE: 
        Join<User, Role> roleJoin = userRoot.join("role");
        return cb.equal(cb.lower(roleJoin.<String> get("name")), searchCriteria);