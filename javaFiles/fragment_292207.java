final List<String> names = mPeople.stream()
    .map( it -> it.getName())
    .collect(Collectors.toList());

final List<Integer> ages= mPeople.stream()
    .mapToInt( it -> it.getAge())
    .collect(Collectors.toList());