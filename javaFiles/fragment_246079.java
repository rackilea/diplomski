Map<String, Map<String, Tuple3<Long, Long, Long>>> res3 =
        persons.stream()
               .collect(toMap(p -> p.subject,
                              p -> {
                                  Map<String, Tuple3<Long, Long, Long>> value = new HashMap<>();
                                  value.put(p.department, new Tuple3<>(p.mark1, p.mark2, p.mark3));
                                  return value;
                              },
                              (v1, v2) -> {
                                   v2.forEach((k, v) -> v1.merge(k, v, (t1, t2) -> new Tuple3<>(t1.e1 + t2.e1, t1.e2 + t2.e2, t1.e3 + t2.e3)));
                                   return v1;
                              }
               ));