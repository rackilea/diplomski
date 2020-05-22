List<Object> result =
    new ArrayList<>(
        new LinkedHashSet<>(
            FluentIterable.from(complexNestedCollection)
                .transformAndConcat(
                    new Function<List<Map<String, List<Object>>>, Iterable<Map<String, List<Object>>>> () {
                        public Iterable<Map<String, List<Object>>> apply(final List<Map<String, List<Object>>> input) {
                            return input;
                        }
                    }
                ).transformAndConcat(
                    new Function<Map<String, List<Object>>, Iterable<List<Object>>> () {
                        public Iterable<List<Object>> apply(final Map<String, List<Object>> input) {
                            return input.values();
                        }
                    }
                ).transformAndConcat(
                    new Function<List<Object>, Iterable<Object>> () {
                        public Iterable<Object> apply(final List<Object> input) {
                            return input;
                        }
                    }
                ).toList()
        )
    );