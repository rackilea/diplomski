JTextField topicTitle = new JTextField();
    JTextField topicDesc = new JTextField();
    Object[] message = {"Title: ", topicTitle, "Description: ", topicDesc};


    Object[] options = { "Yes", "No" };
    int n = JOptionPane.showOptionDialog(new JFrame(),
            message, "",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            options, options[1]);
    if(n == JOptionPane.OK_OPTION){ // Afirmative
        //.... 
    }
    if(n == JOptionPane.NO_OPTION){ // negative
        //....
    }
    if(n == JOptionPane.CLOSED_OPTION){ // closed the dialog
        //....
    }