public static String replace(String str, int index, char replace){     
    if(str==null){
        return str;
    }else if(index<0 || index>=str.length()){
        return str;
    }
    char[] chars = str.toCharArray();
    chars[index] = replace;
    return String.valueOf(chars);       
}

public static void main (String [] args){

    Scanner sc = new Scanner(System.in);

    String word = "Sample";
    String temp = "";
    String letter = null;

    int n;
    int m=0;
    int p = 0;

    for (n = 0; n<word.length(); n++){
        temp = temp + word.replaceAll(word, "-"); //replaces the String word with "-" and prints
    }

    System.out.print(temp); 

    while (m <= 5){ //the player can only guess incorrectly 5 times
        System.out.println("\nEnter a letter:");
        letter = sc.nextLine();

        letter.toLowerCase();
        if (word.contains(letter) == true){
            p = word.indexOf(letter);
            temp = replace(temp, p , word.charAt(p)); //if the word contains the letter, "-" is replaced by the letter.
            System.out.println(temp);
        }

        else {
            System.out.print("\nMissed: "+letter); //if not, Missed: +the given letter
            m++; //to count for incorrect guesses
        }    
    }
    System.out.println("Game Over.");
}