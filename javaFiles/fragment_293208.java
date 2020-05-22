final List<String> list = Arrays.asList("race", "box");
final List<String> transformed =
    Lists.newArrayList(Iterables.transform(list, new Function<String, String>() {

        @Override
        public String apply(final String input) {
            return new StringBuilder().append(input).append("car").toString();
        }
    }));
System.out.println(transformed);