collection.stream()    // Stream<U> #0
          .filter(...) // Stream<U> #1
          .sorted()      // Stream<U> #2
          .map(...)    // Stream<V> #3
          .collect(toList()) // List<V> sorted by U.
          ;