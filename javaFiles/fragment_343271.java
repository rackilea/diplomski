return FluentIterable.from(groups).transform(new Function<String, CustomObject>() {
        @Override
        public CustomObject apply(String input) {
            String[] split = Iterables.toArray(
               Splitter.on(':').trimResults().omitEmptyStrings().split(input),
               String.class);
            if(split.length!=2) return null; // bad input data
            String one = split[0];
            String two = split[1];
            return new CustomObject(one, two);
        }
    }).filter(notNull()).toImmutableList();
         //   ^^  -- Predicates.*