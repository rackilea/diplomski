import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitions {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Address address1 = new Address(1, "X Street", 100);
        Address address2 = new Address(2, "X Street", 100);
        Address address3 = new Address(3, "X Street", 100);
        Address address4 = new Address(4, "Y Street", 101);
        Address address5 = new Address(5, "Y Street", 101);
        Address address6 = new Address(6, "Z Street", 102);
        persons.add(new Person(1, "P1", address1));
        persons.add(new Person(2, "P2", address2));
        persons.add(new Person(3, "P3", address3));
        persons.add(new Person(4, "P4", address4));
        persons.add(new Person(5, "P5", address5));
        persons.add(new Person(6, "P6", address6));
        final List<List<Person>> groupedPersons = persons.stream()
            .collect(Collectors.groupingBy(o -> o.address.streetName))
            .entrySet().stream()
            .map(Map.Entry::getValue).collect(Collectors.toList());
        groupedPersons.forEach(people -> {
            System.out.print("[");
            System.out.print(people.stream().map(person -> String.format("person%d", person.personId)).collect(Collectors.joining(",")));
            System.out.print("]");
        });

    }

    public static class Person {

        public int personId;
        private String name;

        private Address address;

        public Person() {

        }

        public Person(int personId, String name, Address address) {
            super();
            this.personId = personId;
            this.name = name;
            this.address = address;
        }

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" + "personId=" + personId + ", name=" + name + ", address=" + address + '}';
        }

    }

    public static class Address {

        private int houseNumber;
        private String streetName;
        private int streetId;
        public Address() {

        }
        public Address(int houseNumber, String streetName, int streetId) {
            this.houseNumber = houseNumber;
            this.streetId = streetId;
            this.streetName = streetName;
        }

        public int getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public int getStreetId() {
            return streetId;
        }

        public void setStreetId(int streetId) {
            this.streetId = streetId;
        }

        @Override
        public String toString() {
            return "Address{" + "houseNumber=" + houseNumber + ", streetName=" + streetName + ", streetId=" + streetId + '}';
        }

    }
}