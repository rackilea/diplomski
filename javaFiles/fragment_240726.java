public class Person implements Comparable {
        private String country;
        private String state;
        private String city;

        @Override
        public boolean equals(Object o) {
             //it's important but I removed it for readability
        }

        @Override
        public int hashCode() {
            return getCountryStateCityHashCode(country, state, city);
        }

        @Override
        public int compareTo(Object o) {
            //could be further improved by storing hashcode in a field to avoid re-calculation on sorting
            return hashCode() - o.hashCode();
        }

    }

    public class Address implements Comparable {
        private String country;
        private String state;
        private String city;


        @Override
        public boolean equals(Object o) {
             //removed for readability
        }

        @Override
        public int hashCode() {
            return getCountryStateCityHashCode(country, state, city);
        }

        @Override
        public int compareTo(Object o) {
            //could be further improved by storing hashcode in a field to avoid re-calculation on sorting
            return hashCode() - o.hashCode();
        }

    }

    public class AddressPersonAdapter extends Person {
        private final Address delegate;

        public AddressPersonAdapter(Address delegate) {
            this.delegate = delegate;
        }

        @Override
        public boolean equals(Object o) {
            return delegate.equals(o);
        }

        @Override
        public int hashCode() {
            return delegate.hashCode();
        }
    }