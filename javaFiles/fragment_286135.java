while (!this.done) {
    for (int i = 0; i < this.iterations; i++) {
        current = this.population.get(i);
        theBestOnes = current.getTheBestSpecimen();
        bestCase = new BestSpecimen(i+1, theBestOnes);

        final String text = bestCase.toString()"+\n";
        Platform.runLater(() -> resultsTA.appendText(text));

        this.updateProgress(i, iterations);
        next = Population.createParentPopulationFromExistingOne(current);
        next.fillPopulation();
        this.population.add(this.population.size(), next);
    }
    done = true;
}
return null;