public Collection<Anmial> commonMethod(Cage cage, IConfiguration configuration, Runnable runnable) {
    checkPrerequisite(cage);
    String cagePath = cage.getPath();
    File animalStore = AnimalStorage.openFile(cage, configuration);

    //***/
    runnable.run();
    //***/

    animalStore.closeFile();
    return result;
}