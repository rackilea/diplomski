String[][] array = new String[][]{{"a", "b"}, {"a", "c"}, {"b", "d"}};

Map<String, String> m = Arrays.stream(array)
                              .collect(Collectors.toMap(  kv -> kv[0],
                                                          kv -> kv[1],
                                                          (oldV, newV) -> newV)
                                                       ));