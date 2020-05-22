public interface CypherDslRepository<T> {
    Page<T> query(Execute query, Map<String, Object> params, Pageable page);
    Page<T> query(Execute query, Execute countQuery, Map<String, Object> params, Pageable page);
    EndResult<T> query(Execute query, Map<String, Object> params);
}


public interface CustomerQueryRepository extends GraphRepository<Customer>, 
                                                 CypherDslRepository<Customer> {
}