final Collection<String> transformed =
    Collections2.transform(list, new Function<String, String>() {

        @Override
        public String apply(final String input) {
            return new StringBuilder().append(input).append("car").toString();
        }
    });