Object[] options = {"Ja", "Nej"};
    int test = JOptionPane.showOptionDialog(null,
        spm,
        "TestTwo", //the name of the window
        JOptionPane.YES_NO_OPTION, //Type of options, those two buttons at bottom of box
        JOptionPane.PLAIN_MESSAGE, //The JOptionPane type
        null, //Icon to be applied to dialog
        options, //implements the values from the top
        options[0]); //The default selected component when dialog opens