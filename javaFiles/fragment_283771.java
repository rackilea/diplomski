List<Hero> heroes = Arrays.asList(
        new Hero("Iron Man", "Being Iron Man, duh", 48),
        new Hero("Spider-Man", "Spidey things", 16)
);

List<AlterEgo> alterEgos = heroes.stream()
        .map(x -> new AlterEgo(x.getAge()))
        .collect(Collectors.toList());