@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  @Query(value = "SELECT * FROM T_CARS c where c.USER_ID = :id", nativeQuery = true)
  Collection<Car> findByUserId(@Param("id") Long id);

}