public void printAnimalFromNames(String... s) {
    try (Stream<String> stream = Arrays.stream(s)) {
        stream.forEach(x -> {
            try {
                printAnimalPage(AnimalInfo.get(findSpecie(x)));
            } catch (Exception e) {
                System.out.println("this specie " + x + " don't seem to exist");
            }
        });
    }
}