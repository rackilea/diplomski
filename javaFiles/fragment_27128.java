public Model(Model other) {
    fish = new ArrayList<Fish>();
    plants = new ArrayList<Plant>();
    this.landscape = other.landscape;

    for(Fish fishy: other.fish){
        this.fish.add(new Fish(fishy));
    }

    for(Plant planty: other.plants){
        this.plants.add(new Plant(planty));
    }
}