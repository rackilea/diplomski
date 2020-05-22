public class Person {
    private final String name;
    private Date birthDate;

    public class Date {
        private final int year, month, day;

        public Date(final int year, final int month, final int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String toString() {
            // look at me, I can access attributes of the enclosing Person
            return name + " is associated with the year " + year;
        }
    }

    public Person(final String name) {
        this.name = name;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public static final void main(final String... arguments) throws Exception {
        final Person person = new Person("name");
        final Date birthDate = person.new Date(2015, 11, 9);
        person.setBirthDate(birthDate);
    }
}