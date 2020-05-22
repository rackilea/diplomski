int[] binArray = new int[100];
int bins = 10; 
int numOfIterations = 100/bins;
int binElement = 0;
for (int i=0; i<numOfIterations; i++) {
    binElement = binElement + bins;
    binArray[i] = binElement ;
    System.out.println(binArray[i]);
}