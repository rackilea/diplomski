//  fields declared in *class* and are null:
private JTextField[] textFields;
private JTextField[] gTextFields;

    private class TheHandler implements ActionListener 

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == clickButton) {
                // get user input

                if (textFields == null && gTextFields == null) {
                    textFields = new JTextField[someInt];
                    gTextFields = new JTextField[someInt];
                    // use for loop to fill arrays and place into GUI

                }

            } else if (event.getSource() == calcAvg) {

                // extract data from the JTextField arrays,
            }
        }
    }