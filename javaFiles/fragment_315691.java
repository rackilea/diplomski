Collections.sort(weeks, new Comparator<Week>() {
        @Override
        public int compare(final Week week1, final Week week2) {
            return week1.compareTo(week2);
        }
    });