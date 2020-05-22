static int rollValue;
...

 diceRollBut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    rollValue = diceRoll();
                }
            });