public boolean storeAnimals(Cage cage, Collection<Anmial> animals, IConfiguration configuration) {
    commonMethod(cage, animals, configuration, new Runnable() {
        public void run() {
            System.out.println("something special");
        }
    });
    return true;
}