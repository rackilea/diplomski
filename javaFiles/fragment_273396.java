public static void toEnglish(String s1) {
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