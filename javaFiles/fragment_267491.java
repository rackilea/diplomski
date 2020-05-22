public class Scrambler {

    public static void main(String[] args) {

        boolean userDone = true; 
        String word;

        Scanner in = new Scanner(System.in);                      
        getInputAndScramble(in); //Extracted method to get Scanner input and scramble

        do {
            System.out.println("Would you like to enter another word? y/n");
            word = in.next();
            while (userDone) {
                if (word.equals("y")) {
                    getInputAndScramble(in);
                    break;
                } else if (word.equals("n")) {                          
                    userDone = false;
                } else {
                    System.out.println("Invalid input, please enter more than 3 letter words."); 
                }
            }
        } while (userDone); //continue until "n"
    }

    private static void getInputAndScramble(Scanner in) {
        System.out.println("Please enter a word to be scrambled"); 
        String word = in.next();                               
        System.out.println(swapLetters(word));
    }

    private static String swapLetters(String word) { 

        /* Convert word into an ArrayList of characters. 
           Create ArrayList size of word, 
           convert String word into a char array and insert every char in                
           the char array into our ArrayList.
        */

        ArrayList<Character> chars = new ArrayList<>(word.length());
        for (char c : word.toCharArray()) {
            chars.add(c);
        }

        //Shuffle, omitting first and last letters
        Collections.shuffle(chars.subList(1, chars.size()-1));

        //Add shuffled letters into an array to output as a word entity
        char[] shuffled = new char[chars.size()];
        for (int i = 0; i < shuffled.length; i++) {
            shuffled[i] = chars.get(i);
        }
        //Return shuffled String
        return new String(shuffled);
    }
}