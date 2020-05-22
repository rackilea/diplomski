Stream.concat(stream1, stream2)
       .collect(Collectors.collectingAndThen(
               Collectors.toMap(Student::getNo,
                    Function.identity(),
                    (l, r) -> l,
                    LinkedHashMap::new), 
                    f -> f.values().stream()));