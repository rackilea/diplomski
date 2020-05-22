public class Unscramble{

    public static void main(String[] args){

        char[] orig = args[0].toCharArray();
        char[] shuffled = args[1].toCharArray(); 
        int count = 0;

        while(count < orig.length){

            if(!(orig[count] == shuffled[count]))
                shuffled = revealLetter(shuffled,orig, count);

            count++;
            System.out.println(count + " " + new String(shuffled));
        }
    }


    /*
    * Reveal letter
    * @param shuffled the shuffled array
    * @param original original char array
    * @param index index of letter to reveal
    */
    public static char[] revealLetter(char[] shuffled, char[] original, int index){
      shuffled[index] = original[index];
      return shuffled;
    }
}