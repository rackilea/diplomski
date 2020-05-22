List<Pet> namesList = new LinkedList<>(
        Arrays.asList(
                new Pet("cats", 0, 0),
                new Pet("mice", 0, 0)
        )
);

List<Pet> petsList = new LinkedList<>(
        Arrays.asList(
                new Pet("dogs", 16, 18),
                new Pet("cats", 36, 99),
                new Pet("parrots", 85, 25),
                new Pet("mice", 70, 28),
                new Pet("hamsters", 12, 41),
                new Pet("guinea pigs", 75, 95)
        )
);

List<Pet> newList = petsList.stream()
        .filter(t -> namesList.contains(t))
        .collect(Collectors.toList());//find the necessary objects

petsList.removeAll(newList);//remove them from the principal list
petsList.addAll(0, newList);//add the result on the top