public void keyTyped(KeyEvent e) {
    JList src = (JList)e.getSource();
    ListModel model = src.getModel();

    if (model.getSize() == 0 || e.isAltDown() ||
            BasicGraphicsUtils.isMenuShortcutKeyDown(e) ||
            isNavigationKey(e)) {
        // Nothing to select
        return;
    }
    boolean startingFromSelection = true;

    char c = e.getKeyChar();

    long time = e.getWhen();
    int startIndex = adjustIndex(src.getLeadSelectionIndex(), list);
    if (time - lastTime < timeFactor) {
        typedString += c;
        if((prefix.length() == 1) && (c == prefix.charAt(0))) {
            // Subsequent same key presses move the keyboard focus to the next
            // object that starts with the same letter.
            startIndex++;
        } else {
            prefix = typedString;
        }
    } else {
        startIndex++;
        typedString = "" + c;
        prefix = typedString;
    }
    lastTime = time;

    if (startIndex < 0 || startIndex >= model.getSize()) {
        startingFromSelection = false;
        startIndex = 0;
    }
    int index = src.getNextMatch(prefix, startIndex,
                                 Position.Bias.Forward);
    if (index >= 0) {
        src.setSelectedIndex(index);
        src.ensureIndexIsVisible(index);
    } else if (startingFromSelection) { // wrap
        index = src.getNextMatch(prefix, 0,
                                 Position.Bias.Forward);
        if (index >= 0) {
            src.setSelectedIndex(index);
            src.ensureIndexIsVisible(index);
        }
    }
}