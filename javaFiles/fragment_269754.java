public static void combinations2(String[] values, String current, Set<Set<String>> accumulator, int ones, int zeroes) {
        if (ones + zeroes == 0) {
            accumulator.add(IntStream.range(0, values.length)
                    .filter(position -> '1' == current.charAt(position))
                    .mapToObj(position -> values[position])
                    .collect(Collectors.toSet()));
            return;
        }
        if (ones > 0) {
            combinations2(values, current + "1", accumulator, ones - 1, zeroes);
        }
        if (zeroes > 0) {
            combinations2(values, current + "0", accumulator, ones, zeroes - 1);
        }
    }