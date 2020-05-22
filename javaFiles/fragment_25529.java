public class Person {
    private final String name;
    private final Date birthDate;

    public static class Date {
        private final int year, month, day;

        public Date(final int year, final int month, final int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String toString() {
            // I do not know about any Person
            return "year: " + year;
        }
    }

    public Person(final String name, final Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public static final void main(final String... arguments) throws Exception {
        final Person person = new Person("name", new Date(2015, 11, 9));
    }
}