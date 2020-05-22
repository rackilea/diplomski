public class Person {
        String name;
        int id;
        double workTime;

        public Person(String name, int id, double workTime) {
            this.name = name;
            this.id = id;
            this.workTime = workTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, id);
        }
    }