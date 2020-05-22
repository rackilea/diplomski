int cheetahNumber = 77;

Animal cheetah = animals.stream()
  .filter((animal) -> animal.getNumber() == cheetahNumber)
  .findFirst()
  .orElse(Animal.DEFAULT);