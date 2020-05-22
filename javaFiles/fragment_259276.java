if (myListOfCars.size() == myListOfEngines.size()) {
    IntStream.range(0, myListOfCars.size())
        .forEach(
            i -> myListOfCars.get(i).setEngine(myListOfEngines.get(i)
        )
    );
}