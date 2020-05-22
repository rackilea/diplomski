package morsecodejavaprogram;

import javax.swing.JOptionPane;

public class MorseCodeJavaProgram {
    static String[][] morseEnglish = {{"a",".-"}, {"b","-..."}, {"c","-.-."}, {"d","-.."}, {"e","."},
            {"f","..-."}, {"g","--."}, {"h","...."}, {"i",".."}, {"j",".---"}, {"k","-.-"},
            {"l",".-.."}, {"m","--"}, {"n","-."}, {"o","---"}, {"p",".--."}, {"q","--.-"},
            {"r",".-."}, {"s","..."}, {"t","-"}, {"u","..-"}, {"v","...-"}, {"w",".--"}, 
            {"x","-..-"}, {"y","-.--"}, {"z","--.."}, {" ","|"}, {".",".-.-.-"}, {",","--..--"},
            {":","---..."}, {"?","..--.."}, {"'",".----."}, {"-", "-....-"}, {"/","-..-."}, 
            {"\"",".-..-."}, {"@",".--.-."}, {"=","-...-"}, {"(","-.--.-"}, {")","-.--.-"}, 
            {"0","-----"}, {"1",".----"}, {"2","..---"}, {"3","...--"}, {"4","....-"}, {"5","....."},
            {"6","-...."}, {"7","--..."}, {"8","---.."}, {"9","----."}};

    public static void toMorse( String s3 ) {
        String translation = "";
        for ( int i = 0; i < s3.length(); i++ ) {
            String c = s3.substring(i, i+1);
            for (int j = 0; j < morseEnglish.length; j++){
                if (morseEnglish[j][0].equals(c)) {
                        if (translation.equals("")) { translation = morseEnglish[j][1]; }
                        else { translation+= " " + morseEnglish[j][1]; }
                }
            }
        }
        System.out.println("Morse Code:  " + translation);
        JOptionPane.showMessageDialog(null, translation, "English To Morse Code", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void toEnglish( String s1 ) {
        String code[] = s1.split(" ");
        String translation = "";
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < morseEnglish.length; j++){
                if (morseEnglish[j][1].equals(code[i])) {
                    translation+= morseEnglish[j][0];
                }
            }
        }
        System.out.println("English:  " + translation);
        JOptionPane.showMessageDialog(null, translation, "Morse Code To English", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main( String [] args) {
        JOptionPane.showMessageDialog(null, "Select OK To Begin Translating:", "Morse Code/English Translator", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Begin Program");
        String s2 = "";
        while (!s2.toLowerCase().equals("quit")) {
            s2 = UserInput.getString( "Enter either 'To Morse' or 'To English'.\n"
                    + "To Quit enter the word 'Quit':\n(not case sensitive)\n" );
            if (s2 == null) { break; }
            if ("to morse".equals(s2.toLowerCase())  ) {
                String s3 = UserInput.getString( "Please type a phrase in English" );
                if (s3 != null) { toMorse(s3.toLowerCase()); }
            }
            if ("to english".equals(s2.toLowerCase()) ) {
                String s1 = UserInput.getString( "Please type a phrase in Morse Code" );
                if (s1 != null) { toEnglish(s1.toLowerCase()); }
            }
        }
    }
}