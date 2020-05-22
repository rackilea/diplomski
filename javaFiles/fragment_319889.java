@Repository
public interface StuffRepository extends JpaRepository<Stuff, Integer>, JpaSpecificationExecutor<Stuff> {


String QUERY = "SELECT s "    
    + "FROM Stuff s "
    + "JOIN s.foo f"
    + "WHERE f.id = :id";

@Query(value = QUERY)   
List<Stuff> findByFooId(@Param("id") String id);


@Query(value= QUERY)   
Page<Stuff> findByFooId(@Param("id") String id,  Pageable pageable);