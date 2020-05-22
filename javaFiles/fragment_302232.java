int generationCount = 0;
while(myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
  generationCount++;
  System.out.println("Generation: "+generationCount+" Fittest: "+myPop.getFittest().getFitness());
  myPop = Algorithm.evolvePopulation(myPop);
}