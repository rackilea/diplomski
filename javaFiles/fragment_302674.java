List<Filters> filteredList =  filterList.stream().filter(new Predicate<Filters>() {
        @Override
        public boolean test(Filter f) {
            return f.id == some-id;
        }
}).collect(Collectors.toList());