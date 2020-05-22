public class Main {
    public static void main(String[] args) {
       //Test

       System.out.println(new Word("augusto").changeChar('x', 0));
   }
}

class Word {

    private int mLength;
    private char [] arrayChar;

    Word(String x){
        this.mLength = x.length();
        this.arrayChar = x.toCharArray();
    }

    public String changeChar(char c, int position) {
        return changeChar(c, position, 0);
    }

//This Method changes to char "c" from a string "s", given the position "p"
    private String changeChar(char c, int position, int currentIndex){
        if (currentIndex == mLength - 1) {
            return new String(arrayChar);
        } else if (currentIndex == position){
            arrayChar[currentIndex] = c;
            return new String(arrayChar);
        } else {
            return changeChar(c, position, currentIndex + 1);
        }
    }
}