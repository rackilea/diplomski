int n = JOptionPane.showOptionDialog(null,
        "Would you like to continue or stop procedure?","Please confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]); 

...
if (n == JOptionPane.YES_OPTION) {
    ...
}
else if (n == JOptionPane.NO_OPTION) {
    ...
}