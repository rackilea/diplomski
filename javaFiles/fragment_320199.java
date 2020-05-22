class Population<A extends Animal> {
  final List<A> animals = new ArrayList<>();

  void add(A animal) {
    animals.add(animal);
  }
}