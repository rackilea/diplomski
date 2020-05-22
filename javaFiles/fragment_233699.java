Object[] options = {"Yes, please", "No way!"};
int n = JOptionPane.showOptionDialog(frame,
                "Would you like green eggs and ham?",
                "A Silly Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
if (n == JOptionPane.YES_OPTION) {

} else if (n == JOptionPane.NO_OPTION) {

} else {

}