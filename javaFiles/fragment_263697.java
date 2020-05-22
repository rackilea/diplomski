@Repository
public interface AccomodationDAO extends JpaRepository<Accomodation, Long> {

@Query(value = "SELECT * FROM accomodation a WHERE earth_circle_distance(?1, a.geographical_position) < ?2", nativeQuery = true)
Accomodation findByRange(Point location, int range);

}