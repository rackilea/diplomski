import acm.program.*;
public class Morse extends Program{
public void run(){
    println("Hello, please enter the text that you want to convert to Morse.");
    String txt = readLine();
    txt = txt.toUpperCase();
    for(int j = 0;j <= txt.length()-1;j++){
        int i;
        for (i=0;i<=26;i++){ //alphabet[26] is a white space
            if (alphabet[i]==txt.charAt(j)){
                if (txt.charAt(j)==' '){
                    System.out.print(System.lineSeparator());
                }else{
                    System.out.print(" " + code[i] + " ");
                }
            }
        }
    }
}
private final String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.","--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-","-.--", "--..","\n"};
private final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
}