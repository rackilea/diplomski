public interface UserRepository extends JpaRepository<User, Long> {
   String QUERY_TEXT = "SELECT u FROM User u WHERE ...";

   ... some repository methods ...

   @Query(QUERY_TEXT)
   List<User> findUsersByCustomCriteria(String criteria);

   @Query(QUERY_TEXT)
   Set<User> findUsersByCustomCriteria(String criteria, Sort sort);

   @Query(QUERY_TEXT)
   Page<User> findUsersByCustomCriteria(String criteria, Pageable pageable);
}