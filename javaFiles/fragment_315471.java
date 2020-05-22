List<Human> humans = ... // init 
List<SuperHuman> superHumans = ... // init

Set<Long> superHumanIds = superHumans.stream()
    .map(SuperHuman::getHumanId)
    .collect(toSet());

humans.stream()
    .filter(human -> superHumanIds.contains(human.getHumanId()))
    .map(this::convert)
    .forEach(superHumans::add);

superHumans.sort(Comparator.comparing(SuperHuman::getAge));