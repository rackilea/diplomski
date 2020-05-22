public static void main(String[] args) {

    class People {
        String peopleName;
        int maximumLength;

        public People(String peopleName, int maximumLength) {
            this.peopleName = peopleName;
            this.maximumLength = maximumLength;
        }

        public int getMaximumLength() {
            return maximumLength;
        }

        @Override
        public String toString() {
            return "{" +
                    "peopleName='" + peopleName + '\'' +
                    ", maximumLength=" + maximumLength +
                    '}';
        }
    }

    List<People> people = Arrays.asList(new People("John", 175), new People("Jane", 168),
            new People("James", 189), new People("Mary", 167),
            new People("tim", 162));
    people.stream().sorted(Comparator.comparingInt(People::getMaximumLength)).limit(3).forEach(System.out::println);
    System.out.println();
    people.stream().sorted(Comparator.comparingInt(People::getMaximumLength).reversed()).limit(3).forEach(System.out::println);
}