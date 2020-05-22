@Mapper
public interface TireMapper {

    CarDto map(Car car);

    default List<TirePlate> map(List<String> tires, String plate) {
        List<TirePlate> tirePlates = new ArrayList<>(tires.size());

        for(String tire: tires) {
            tirePlates.add(map(tire, plate));
        }
        return tirePlates;
    }

    TirePlate map(String tire, String plate);
}