public ResponseOption(int rowCount, JFrame frame) {

    this.rowCount = rowCount;
    String question = "There are " + rowCount + " Tweets. Do you want to print them?";
    n = JOptionPane.showOptionDialog(frame,
            question,
            "Question",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,       
            null,                               
            options,                            
            options[0]); 
    // do something with n here?
}