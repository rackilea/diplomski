List<A> out = list.stream()
    .collect(Collectors
        .collectingAndThen(
            Collectors.toMap(ele -> ele.getFieldA(), Function.identity(), (a, b) -> {
              a.setFieldB(a.getFieldB() + b.getFieldB());
              return a;
            }), m -> new ArrayList<>(m.values())));