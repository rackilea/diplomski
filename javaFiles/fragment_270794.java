@Stateless
public class CarService {

    @Inject
    private CarRepository carRepository;

    public List<Car> findAllCars() {
        return carRepository.findAllCars();   
    }

    // Many other methods
}