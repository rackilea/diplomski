Collections.sort(person, new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.parseInt(o1.getAgeBand().split("-")[0]) - Integer.parseInt(o2.getAgeBand().split("-")[0]);
        }
    });