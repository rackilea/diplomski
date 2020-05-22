int mouseSolvedTotal = 0;
for (int mouseTest = 1; mouseTest <= 4; mouseTest++) {
  int mouseSolved = randomGenerator.nextInt(5);
  System.out.println("How many mazes did mouse " + mouseTest + " solve? " + mouseSolved);
  mouseSolvedTotal += mouseSolved;
}

int ratSolvedTotal = 0;
for (int ratTest= 1; ratTest <= 4; ratTest++) {
  int ratSolved = randomGenerator.nextInt(5);
  System.out.println("How many mazes did rat " + ratTest + " solve? " + ratSolved);
  ratSolvedTotal += ratSolved;    
}