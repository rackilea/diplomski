public static void findAllCalls(String[] phoneNumbers, int[] callDurations, int size, String targetNumber) 
{
   int match;
   System.out.println("Calls from " + targetNumber + ":");
   //match = find(phoneNumbers, size, 0, targetNumber);
   int i = 0, duration = 0;
   while (i<size)
    {
        if(phoneNumbers[i].equals(targetNumber))
            duration+=callDurations[i];
        i++;
      //System.out.println(phoneNumbers[match] + " duration: " + callDurations[match] + "s");
      //match = find(phoneNumbers, size, match + 1, targetNumber);
   }
   System.out.println(targetNumber+" duration : "+duration+"s");
}