@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    public List<T> findAllByName(String name);
}

@Repository
public interface EmployeeRepository extends MyBaseRepository<Employee,Long>{
}