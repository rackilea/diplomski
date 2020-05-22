Iterables.filter(list, new Predicate<Base>() {
        @Override
        public boolean apply(Base input) {
            return input instanceof Bar;
        }
    });