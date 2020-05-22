/**
 * count letters, adding a bit more all the time
 */
private static int howMany(List<String> tokens) {
    return tokens.stream()
            .parallel()
            .reduce(0, // identity
                    (i, s) -> { // accumulator
                        return s.length() + i;
                    }, (left, right) -> { // combiner
                        return left + right + left; // notice the extra left here
                    });
}