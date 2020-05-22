class CityDistrict {

    List<House> houses;

    public CityDistrict(Supplier<List<House>> implementation) {
        houses = implementation.get();
    }

    public static void main(String[] args) {
        CityDistrict arrayListImpl = new CityDistrict(ArrayList::new);
        CityDistrict linkedListImpl = new CityDistrict(LinkedList::new);
    }

}