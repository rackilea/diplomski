public <T> Predicate getPredicate(Root<T> root, CriteriaBuilder builder, C2Criteria criteria) {

    if (criteria.getOperation().equalsIgnoreCase(">")) {
        return builder.greaterThanOrEqualTo(
                root.get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase("<")) {
        return builder.lessThanOrEqualTo(
                root.get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase(":")) {
        if (root.get(criteria.getKey()).getJavaType().equals(String.class)) {
            return builder.like(
                    root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
    }