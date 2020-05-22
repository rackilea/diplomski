while (nextPopulation too small) {
    Members tournament = randomly choose x members from currentPopulation

    if(crossover){
        Member parents = select best two members from tournament
        Member children = crossover(parents)
        nextPopulation.add(children);
    } else {
        Member parent = select best one member from tournament
        Member child = mutate(parent)
        nextPopulation.add(child);
    }
}