class CityDistrict {

    List<House> houses;

    private CityDistrict(Supplier<List<House>> supplier) {
        houses = supplier.get();
    }

    public CityDistrict() {
        this(ArrayList::new);
    }

    public CityDistrict with(Supplier<List<House>> implementation) {
        return new CityDistrict(implementation);
    }

}