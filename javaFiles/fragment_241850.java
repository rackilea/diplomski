List<String> list = Arrays.asList("ab", "bc", "cd", "");

Map<String, Boolean> alphaToBoolMap = list.stream().collect(Collectors //
        .toMap(Function.identity(), (a) -> {
            return !(a == null || a.isEmpty());
        }));
System.out.println(alphaToBoolMap);