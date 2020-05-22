Stream.concat(collection1.stream(), collection2.stream())
       .collect(Collectors.toMap(Function.identity(),Function.identity(),
       (left, right) -> {
          left.setCount(left.getCount() + right.getCount());
          return left;
       })).values()
         .stream()
         .sorted(Comparator.comparingInt(A::getCount))
         .collect(Collectors.toList());