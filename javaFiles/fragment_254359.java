Map<Integer, List<String>> collated = 
    Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
          .collect(Collectors.toMap(Entry::getKey,
                                    e -> {
                                          List<String> v = new ArrayList<String>();
                                          v.add(e.getValue());
                                          return v;
                                         },
                                    (a, b) -> {
                                         List<String> merged = new ArrayList<String>(a);
                                         merged.addAll(b);
                                         return merged;
                                    }));