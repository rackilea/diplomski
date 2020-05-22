collection.stream() // Stream<U>
          .filter(...) // Stream<U>
          .collect(collectingAndThen(toList(), list -> {
            list.sort(); 
            return list;
          })); // List<V>