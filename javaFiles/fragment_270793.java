@Stateless
public class CarSqlRepository implements CarRepository {

    @PersistenceContext(unitName = "MyUnit")
    private EntityManager entityManager;

    public List<Car> findAllCars() {

    }

    // Many other methods
}