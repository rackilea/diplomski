public class UrbanCommune extends Commune<City>{
    private Cities cities = new Cities();

    @Override
    public void putSettlement(City city) {
        cities.put(City city);
    }
}