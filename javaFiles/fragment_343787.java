final String[] variables = { "1.2", "1.3", "1.4", "1.5" };
double[] result = Doubles.toArray(Collections2.transform(
    Arrays.asList(variables),
    new Function<String, Double>(){

        @Override
        public Double apply(final String input){
            return Double.valueOf(input);
        }
    }));