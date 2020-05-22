public static void performCalculationsForTime(int seconds)
{ 
 // Get start time 
 int secondsStart = System.currentTimeMillis()/1000;
 int requiredEndTime = millisStart + seconds;
 float sum = 0;

 while(secondsStart != requiredEndTime) {
   sum = sum + 0.1;
   secondsStart = System.currentTimeMillis()/1000;
 }
}