public static void main(String[] args) {
    String thing  = "Hello World E";
    String phrase = "";
    char guessChar = 'e';
    String finalstr = "";
    phrase = thing.toLowerCase();
    for (int i = 0; i < thing.length(); i++){
        char test = phrase.charAt(i);
        if (test == ' ') 
        {
            finalstr += " ";
        }
        else if (test == guessChar)
        {
            finalstr += thing.charAt(i);
        }
        else 
        {
            finalstr += "_";
        }
    }
    System.out.println(finalstr);
}