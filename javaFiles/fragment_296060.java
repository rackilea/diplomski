UnaryOperator<Change> integerFilter = change -> {
    String newText = change.getControlNewText();
    // if proposed change results in a valid value, return change as-is:
    if (newText.matches("-?([1-9][0-9]*)?")) { 
        return change;
    } else if ("-".equals(change.getText()) ) {

        // if user types or pastes a "-" in middle of current text,
        // toggle sign of value:

        if (change.getControlText().startsWith("-")) {
            // if we currently start with a "-", remove first character:
            change.setText("");
            change.setRange(0, 1);
            // since we're deleting a character instead of adding one,
            // the caret position needs to move back one, instead of 
            // moving forward one, so we modify the proposed change to
            // move the caret two places earlier than the proposed change:
            change.setCaretPosition(change.getCaretPosition()-2);
            change.setAnchor(change.getAnchor()-2);
        } else {
            // otherwise just insert at the beginning of the text:
            change.setRange(0, 0);
        }
        return change ;
    }
    // invalid change, veto it by returning null:
    return null;
};