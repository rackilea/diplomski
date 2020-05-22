import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;


public class test2 {

    public static class City {
        public final String m_name;

        public City(String aName) {
            m_name = aName;
        }
    }

    public static class CityNameComparator implements Comparator<String>
    {
        public int compare (String c1, String c2) {
            return c1.compareTo(c2);
        }
    }

    public static class CityMap {
        TreeMap<String, City> nameDictionary = new TreeMap<String, City>(new CityNameComparator());

        public Iterator<City> getNameIterator(){
            return nameDictionary.values().iterator();
        }

        public City put(String aName) {
            return nameDictionary.put(aName, new City(aName));
        }
    }

    public static void main(String[] args) {
        CityMap cityMap = new CityMap();
        cityMap.put("d");
        cityMap.put("b");
        cityMap.put("c");
        cityMap.put("a");

        for (Iterator<City> cities = cityMap.getNameIterator(); cities.hasNext(); ) {
            City city = cities.next();
            System.out.println(city.m_name);
        }
    }
}