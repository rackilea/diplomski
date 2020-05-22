public void printEndangered(ArrayList<String> animalNames, int dangerThreshold) {
    animalNames.stream()
               .filter(animal -> getCount(animal) <= dangerThreshold)
               .map(animal -> animal + " is endangered.")
               .forEach(System.out::println);
}