private static void order(List<Person> persons) {

    Collections.sort(persons, new Comparator() {

        public int compare(Object o1, Object o2) {

            String x1 = ((Person) o1).getName();
            String x2 = ((Person) o2).getName();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
               return sComp;
            } 

            Integer x1 = ((Person) o1).getAge();
            Integer x2 = ((Person) o2).getAge();
            return x1.compareTo(x2);
    }});
}