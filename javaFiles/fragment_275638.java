//import java.util.Arrays;

public static String[] unscramble(String[] scrambledStrArr){
   String[] unscramble = new String[scrambledStrArr.length];
   String[] evens = Arrays.copyOfRange(scrambledStrArr, 0, scrambledStrArr.length/2); // note that we can use int truncation here to our benefit
   String[] odds = Arrays.copyOfRange(scrambledStrArr, (scrambledStrArr.length/2)+1, scrambledStrArr.length);
   int evensIndex = 0, oddsIndex = 0;
   for(int i = 0; i < unscramble.length; i++;){
      if(i%2==0){
         unscramble[i] = evens[evensIndex];
         evensIndex++;
      } else {
         unscramble[i] = evens[oddsIndex];
         oddsIndex++;
      }
   }
}