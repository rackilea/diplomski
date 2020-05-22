// Declare mathRadio before you create englishRadio's actionListener.
    JRadioButton mathRadio = new JRadioButton("Math");
    mathRadio.setBounds(6, 43, 70, 23);
    PreferredSubjects.add(mathRadio);

    // Declare historyRadio before you create englishRadio's actionListener.
    JRadioButton historyRadio = new JRadioButton("History");
    historyRadio.setBounds(6, 67, 70, 23);
    PreferredSubjects.add(historyRadio);

    // Declare englishRadio before you assign it an actionListener.
    JRadioButton englishRadio = new JRadioButton("English");
    // Create the actionListener after declaring your three radios.
    englishRadio.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(englishRadio.isSelected())
            {
                mathRadio.setSelected(false);
                historyRadio.setSelected(false);

            }
        }
    });
    englishRadio.setBounds(6, 17, 70, 23);
    PreferredSubjects.add(englishRadio);