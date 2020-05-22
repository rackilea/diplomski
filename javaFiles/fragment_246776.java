public Map<String,Set<String>> PeoplePerSkill(){
    return this.people.stream()
        .<Entry<String, String>>flatMap(p -> 
            p.getSkills().keySet()
                .stream()
                .map(s -> new AbstractMap.SimpleEntry<>(s, p.getName())))
        .collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toSet())));
}