DoubleStream.of(s2)      // Pipe the source array
    .distinct()          // Remove duplicate elements
                         // as they only need to be matched against once
    .anyMatch(value ->   // Consider if any value matches this condition
        IntStream.of(match)  // It equals any value in "match"
                 .distinct() // after removing duplicate elements
                 .anyMatch(matchValue -> matchValue == value));