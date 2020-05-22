/**
 * Asks the user if they want to try something again and
 * returns a boolean representing the user's response.
 * @return true if the user answers Yes, false otherwise.
 */
private static boolean promptToRepeatSelectedOption(){
    int n = JOptionPane.showOptionDialog(null,
            "Try again?",
            "Repeat Selection",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            null,
            null);
    return n == JOptionPane.YES_OPTION;
}