@Transactional(rollbackFor=RuntimeException.class)
public List<Car> saveAllOrNone(List<Car> cars) {
    for(Car car: cars) {
        repo.save(car);
    }
}