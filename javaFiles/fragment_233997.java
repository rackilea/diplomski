class UserSpecs {

    public static Specification<User> isOfType(String type) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.equal(root.get("type"), type);
            }
        };
    }


    public static Specification<User> isInTypes(String... types) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
               In<String> inClause = builder.in(root.get("type"));
               for (String type: types) {
                 inClause.value(type);      
               }
               return inClause;
            }
        };
    }

}