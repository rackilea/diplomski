class Person {
        String name;
        String distance;
        String address;
        String field1;
        String field2;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(distance, person.distance) &&
                    Objects.equals(address, person.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, distance, address);
        }
    }

    class Example {
       public static void main(String[] args) {
            Person person1 = new Person();
            person1.address = "address_1";
            person1.distance = "distance_1";
            person1.name = "name_1";
            person1.field1 = "field1_1";
            person1.field2 = "field2_2";

            Person person2 = new Person();
            person2.address = "address_2";
            person2.distance = "distance_2";
            person2.name = "name_2";
            person2.field1 = "field1_2";
            person2.field2 = "field2_2";

            ArrayList<Person> people = new ArrayList<>(Arrays.asList(person1, person2));
            System.out.println(people);
            ArrayList<Person> otherPeople = new ArrayList<>(Arrays.asList(person1));
            people.removeAll(otherPeople);
            System.out.println(people);
        }
    }