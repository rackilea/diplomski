PrintWriter outFile = new PrintWriter (new File ("bottleCap.txt"));

 for (int x = 0; x < trials; x++){
  int counter = 0;
  double randNum = Math.random();
  trialNumber++;

   while (randNum < 0.8){
   counter ++;
   randNum = Math.random();
   }

 total += counter;
 average = (int) total/trials;
 outFile.println("Trial " + trialNumber + " took " + counter + " drinks.");


 if (trialNumber == trials){
 System.out.println("The average was " + average);

  }
 outFile.close();    
  }