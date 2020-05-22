public Person process(Person px) {
    int age = px.getAge();
    return persons.stream()
                  .filter(p -> !p.equals(px))
                  .min(Comparator.comparingInt(p -> Math.abs(p.getAge() - age)))
                  .orElse(null);
}