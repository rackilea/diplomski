public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")
    public Person findByIdAndFetchRolesEagerly(@Param("id") Long id);

}