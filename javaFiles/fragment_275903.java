class YourClass implements Runnable {
    public void run() {
        List<Random> randomSeedsList
            = IntStream.range(0, getNumberOfSimulations())
                       .mapToObj(Random::new)
                       .collect(Collectors.toList());

        randomSeedsList.parallelStream()
                       .forEach(random -> RandomManager.withRandom(random,
                                                                   ()->runSimulation(…)));
    }
}