public double avgVar(int time){

 double avgVar = 0;

 ArrayList<double[]> avgData = avgDuplicateVars(inputData);

 for(double[] arrVar : avgData){
 avgVar += arrVar[time-1];
 //System.out.print(arrVar[time-1] + "," + arrVar[time] + "," + arrVar[time+1] + "\n");
 //System.out.print(avgVar + "\n");
 }

 avgVar /= numDays(inputData);

 return avgVar;
}

private int numDays(ArrayList<String> varData){

 int n = 0;
 int flag = 0;