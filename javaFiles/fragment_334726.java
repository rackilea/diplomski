@Repository
public interface OsobaRepository extend JpaRepository<Osoba, Integer> {
   @Query(value = "SELECT imie FROM osoba WHERE osoba.id = :id", 
          nativeQuery = true) 
   String findNameById(@Param("id") int id);
}