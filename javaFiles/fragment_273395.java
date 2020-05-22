public static void toMorse(String s3) {
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