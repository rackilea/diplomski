private void updateButtonState() {
    if (rowID > 1 && rowID < 40) {
        previous_question.setEnabled(true);
        next_question.setEnabled(true);
    } else if (rowID == 40) {
        next_question.setEnabled(false);
    } else if (rowID == 1) {
        previous_question.setEnabled(false);
    }
}