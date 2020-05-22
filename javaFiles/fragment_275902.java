class YourClass implements Runnable {
    public void run() {
        ArrayList<Random> randomSeedsList = new ArrayList<>();
        int total = getNumberOfSimulations();
        for (int run = 0; run < total; run++) {
            randomSeedsList.add(new Random(run));
        }
        assert randomSeedsList.size() == total;
        IntStream.range(0, total).parallel()
                 .forEach(run -> RandomManager.withRandom(randomSeedsList.get(run),
                                                          ()->runSimulation(run, …)));
    }
}