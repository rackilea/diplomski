ParameterExpression<String> name2 = criteriaBuilder.parameter(String.class);
    ParameterExpression<String> surname2 = criteriaBuilder.parameter(String.class);
    ParameterExpression<String> password2 = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(
        criteriaBuilder.equal(root.get("name"), name2),
        criteriaBuilder.equal(root.get("surname"), surname2),
        criteriaBuilder.equal(root.get("password"), password2)
    );