BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( filename ) );

for (int i=0;  i< MAX; i++) { // some max 
int[] frequencies = getFrequenciesSomeHow(); //assume I already have the content which i want to print
  write_Frequencies( frequencies, bufferedWriter );
}