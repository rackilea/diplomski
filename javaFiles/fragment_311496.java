btnJ.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        count += 1;
        lblTries.setText(count + " Tries");
        if (wordList[num].indexOf('j') >= 0) {//notice this is >= 0 to get the first char to work
            for (int i = -1; (i = wordList[num].indexOf("j", i + 1)) != -1;){
                hiddenWord = putCharAtPlaces(hiddenWord, 'j',
                        new int[] { i });
                lblWordDisplay.setText(hiddenWord);
                System.out.println(i);
            }
        }
    }
});