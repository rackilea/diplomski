Map<String, Map<String, Tuple3<Long, Long, Long>>> res =
    persons.stream().collect(groupingBy(p -> p.subject,
                                        groupingBy(p -> p.department,
                                                   reducing(new Tuple3<>(0L, 0L, 0L), 
                                                            p -> new Tuple3<>(p.mark1, p.mark2, p.mark3), 
                                                            (t1, t2) -> new Tuple3<>(t1.e1 + t2.e1, t1.e2 + t2.e2, t1.e3 + t2.e3)))));