public class UserSpecification implements Specification<GeoMap> {

    private SearchCriteria criteria;
    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<GeoMap> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.isEmpty()) return null;

        //.. search something

    }
}