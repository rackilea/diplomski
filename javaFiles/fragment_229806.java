private C2Criteria criteria;

public static CustomerSpecification of(C2Criteria criteria) {
    return new CustomerSpecification(criteria);
}

private CustomerSpecification(C2Criteria criteria) {
    this.criteria = criteria;
}

@Override
public Predicate toPredicate
        (Root<CustomerDetail> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    return getPredicate(root, builder, criteria);
}