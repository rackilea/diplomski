public class ContinentFactory {
    private Set<Continent> continents = new HashSet<>();

    public Continent create(String name) {
        Continent continent = new Continent(name);
        continents.add(continent);
        return continent;
    }

    public static class Continent {
        private String continentName;

        public Continent(String continentName) {
            this.continentName = continentName;
        }

        ...
        equals and hashcode 
        ....
    }
}