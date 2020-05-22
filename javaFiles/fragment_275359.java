// creates the JPanel that will hold JButton and JTextArea
    JPanel textAndButtonPanel = new JPanel();

    // the JButton the user will press to see if "name" is hungry
    JButton hungryButton = new JButton("Am I Hungry?");

    // the JTextArea that will initially be blank, but will display
    // "name" is hungry when the JButton is pressed
    JTextArea textArea = new JTextArea(10, 10);

    // sets up the event-handling for the JButton. When the button
    // is pressed, the JTextArea will display "name" is hungry.
    hungryButton.addActionListener(new ActionListener() {   
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(String.format("%s is hungry", name));
        }
    });

    // adds the JButton and JTextArea to the JPanel
    textAndButtonPanel.add(hungryButton);
    textAndButtonPanel.add(textArea);