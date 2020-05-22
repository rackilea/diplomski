public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
switch (criteria.getOperation()) {
    case ":":
        String[] s = criteria.getKey().split("\\.");
        if (s.length == 1) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(criteriaBuilder.upper(
                        root.<String>get(criteria.getKey())), "%" + criteria.getValue().toString().toUpperCase() + "%");
            } else if (root.get(criteria.getKey()).getJavaType() == Date.class) {
                try {
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    return criteriaBuilder.greaterThanOrEqualTo(root.<java.util.Date>get(criteria.getKey()), formatter.parse(criteria.getValue().toString()));
                } catch (ParseException e) {
                }
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        } else {
            //I need a "like" here
            return criteriaBuilder.like(criteriaBuilder.upper(root.join(s[0]).join(s[1]).<String>get(s[2])),"%" + criteria.getValue().toString().toUpperCase() + "%");
        }
    default:
        return null;
}
}