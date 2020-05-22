tf.addActionListener(new ActionListener() {
    int wrong;

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField tf = (JTextField)e.getSource();

        char userEntry = tf.getText().charAt(0);
        jlLetsUsed.setText(jlLetsUsed.getText() + userEntry + " ");

        int level = 2;

        if (!wordList[level].contains(String.valueOf(userEntry))) {
            wrong++;

            if (wrong >= 6) {
                System.out.println("dead");
            }

            return;
        }

        char[] jlabelText = jlLines.getText().toCharArray();

        for (int i = 0; i < wordList[level].length(); i++) {
            if (wordList[level].charAt(i) == userEntry) {
                jlabelText[3 * i] = ' ';
                jlabelText[3 * i + 1] = userEntry;
            }
        }

        jlLines.setText(String.valueOf(jlabelText));
    }
});