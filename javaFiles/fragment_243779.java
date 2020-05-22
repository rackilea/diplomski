public static String StringtoMorse(String str){
    char Alphabet [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    String MorseCode [] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|"};


    for (int i = 0; i < str.length(); i ++){
        for (int j = 0; j < Alphabet.length; j ++){
            if (str.charAt(i) == Alphabet[j]){
                return(MorseCode[j] + " ");
            }
        }
    }
    return null;
}