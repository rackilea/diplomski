int bestFitness = Integer.MIN_VALUE;
Individual bestIndividual = null;
int noImprovementCount = 0;
for (int generationCount = 1;; generationCount++) {
  System.out.println("Generation: "+generationCount+" Fittest: "+myPop.getFittest().getFitness());
  myPop = Algorithm.evolvePopulation(myPop);
  if (bestFitness < myPop.getFittest().getFitness()) {
    bestIndividual = myPop.getFittest();
    bestFitness = bestIndividual.getFitness();
    noImprovementCount = 0;
  } else if (++noImprovementCount == 5) { // X = 5
    break;
  }
}