List<A> aList = new ArrayList<>();
List<B> bList = new ArrayList<>();

Map<String, String> nameDobLookup = bList.stream()
                        .collect(Collectors.toMap(b -> b.name, b -> b.dob));

aList.stream()
        .filter(a -> a.dob == null)
        .forEach(a -> a.dob = nameDobLookup.get(a.name));