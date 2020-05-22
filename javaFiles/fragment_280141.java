public interface Table1Repository            // to use specifications in queries 
        extends JpaRepository<Table1, Long>, JpaSpecificationExecutor<Table1> {

    @SuppressWarnings("serial")
    public static Specification<Table1> multiLikeColumn1(List<String> likePatterns) {
        return new Specification<Table1>() {
            @Override
            public Predicate toPredicate(Root<Table1> root, CriteriaQuery<?> query,
                                            CriteriaBuilder criteriaBuilder) {
                Path<String> column1 = root.get("column1");
                // create a Predicate for each "column1 like 'xy%az%' you need
                List<Predicate> predicates = likePatterns.stream()
                    .map(likePattern -> criteriaBuilder.like(column1, likePattern))
                    .collect(Collectors.toList());
                // then "concatenate" list of likes with "OR"
                return criteriaBuilder.or(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}