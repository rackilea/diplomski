public class Country {

    Integer idLvl1;
    String  nameLvl1;

    public Country(Integer idLvl1, String  nameLvl1) {
    }

    List<City> cities;

}

public class City {

    Integer idLvl2;
    String  nameLvl2;

    public City(Integer idLvl2, String  nameLvl2) {
    }
}

public class MyDTOConverter {

    public static Collection<Country> covert(List<MyDTO> dtos){
        Map<Integer, Country> countries = new LinkedHashMap<Integer, Country>();
        for (MyDTO myDTO : dtos) {
            //First adding the country if it doesn't exist
            if (!countries.containsKey(myDTO.idLvl1)){
                countries.put(myDTO.idLvl1, new Country(myDTO.idLvl1, myDTO.nameLvl1));
            }

            //Adding city in the existing country.
            countries.get(myDTO.idLvl1).cities.add(new City(myDTO.idLvl2, myDTO.nameLvl2));
        }

        return countries.values();
    }

}