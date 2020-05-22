String[] topNames = 
    IntStream.range(0, rates.length)
             .boxed()
             .sorted(Comparator.comparing(i -> -1 * rates[i]))
             .limit(N)
             .map(i -> names[i])
             .toArray(String[]::new);