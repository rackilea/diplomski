@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

    List<Project> findEmployeeById(int eId);

}