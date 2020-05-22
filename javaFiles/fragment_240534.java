for(int i = 0; i<wordList[level].length(); i++){
    if(wordList[level].charAt(i) == userEnteredChar){
        jlabelText[3 * i] = ' ';
        jlabelText[3 * i + 1] = userEnteredChar;
        jlLines.setText(String.valueOf(jlabelText));
    }
}

if(!wordList[level].contains(letter)){
    wrong++;
}

if(wrong>=6){
    System.out.println("dead");
}