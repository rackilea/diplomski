static class PeopleByDays extends HashSet<Person> {
        private final Set<Date> days = new HashSet<Date>();

        public PeopleByDays() {
            super();
        }
        public PeopleByDays(Date day, Person... people) {
            super(Arrays.asList(people));
            this.days.add(day);
        }
        public PeopleByDays(PeopleByDays other) {
            super(other);
            this.days.addAll(other.days);
        }

        public List<Date> getDays() {
            return new ArrayList<Date>(this.days);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            if (c instanceof PeopleByDays) {
                this.days.addAll(((PeopleByDays)c).days);
            }
            return super.retainAll(c);
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o) && this.days.equals(((PeopleByDays) o).days);
        }
        @Override
        public int hashCode() {
            return super.hashCode() + this.days.hashCode();
        }
    }