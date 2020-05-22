import org.springframework.data.repository.query.Param;
...

@Query(value  = 
    " SELECT a.id, a.lastname FROM person a" + 
    " WHERE a.name = :name AND a.birthday = :date ", nativeQuery = true)
public List<Object[]> getPersonInfo(
    @Param("name") String name, 
    @Param("date") Date date);