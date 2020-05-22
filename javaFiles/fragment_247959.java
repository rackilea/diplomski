public class WeddingDetails {

    public static void main(String[] args) {

        Bride person = new Bride("Amy Cronos", 29);
        Location place = new Location("Tonsley", "South Rd");
        Wedding wed = new Wedding(person, place);
        show(wed);
    }

    public static void show(Wedding wed) {
        System.out.println("Wedding data:");
        System.out.println("Bride: " + wed.getBride().getName() + ", age: " + wed.getBride().getAge());
        System.out.println("Location: " + wed.getPlace().getStreet() + ", suburb: " + wed.getPlace().getSuburb());

    }

    public static class Location {

        private String suburb;
        private String street;

        Location(String suburb, String street) {
            this.suburb = suburb;
            this.street = street;
        }

        public String getSuburb() {
            return suburb;
        }

        public String getStreet() {
            return street;
        }
    }

    public static class Bride {

        private String name;
        private int age;

        Bride(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }

    public static class Wedding {

        private Bride person;
        private Location place;

        Wedding(Bride person, Location place) {
            this.person = person;
            this.place = place;

        }

        public Bride getBride() {
            return person;
        }

        public Location getPlace() {
            return place;
        }
    }
}