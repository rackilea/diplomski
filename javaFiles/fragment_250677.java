public static void main(String[] args){

    char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                  'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                  ',', '.', '?' };

    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };

    //Scanner keyboard = new Scanner(System.in);

    System.out.println(" This is an English to Morse Code Translator.  ");
    System.out.println(" Please enter what you would like translate ");
    System.out.println("             into Morse Code. ");
    System.out.println(" ============================================ ");

    //String userInput = keyboard.nextLine().toLowerCase();
    String userInput = "TEST".toLowerCase();

    char[] chars = userInput.toCharArray();

    String str = "";
    for (int i = 0; i < chars.length; i++){
        for (int j = 0; j < english.length; j++){

            if (english[j] == chars[i]){
                str = str + morse[j] + " ";  
            }
        }
    }
    System.out.println(str);
}