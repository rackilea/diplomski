void runSimulation(Iterable<? extends Rocket> rockets) {
    int totalCost = 0;
    for (Rocket rocket : rockets)
        do {
            totalCost += rocket.getCost();
        } while (!(rocket.launch() && rocket.land()));
    System.out.println("Total cost:" + totalCost + " Million");
}