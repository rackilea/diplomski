public class PersonFactory {

    private static PersonFactory instance = new PersonFactory();

    public static PersonFactory getInstance() {
        return instance;
    }

    public Person getPerson(Gender gender) {
        return new AbstractPerson(gender);
    }

    public Person getMale() {
        return getPerson(Gender.Male);
    }

    public Person getFemale() {
        return getPerson(Gender.Female);
    }

    private PersonFactory {

    }

    private static class AbstractPerson implements Person {
        private String name;
        private String age; // maybe int ??
        private Gender gender;

        public  AbstractPerson(Gender gender) {
            this.gender = gender;
        }

        @override
        public void setName(String name) {
            this.name = name;
        }

        @override
        public String getName() {
            return name;
        }

        @override
        public void setAge(String age) {
            this.age = age;
        }

        @override
        public String getAge() {
            return age;
        }

        @override
        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @override
        public Gender getGender() {
            return this.gender;
        }
    }   
}