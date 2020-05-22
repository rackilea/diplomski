...
        disableAction("caret-down"); // down arrow
        disableAction("caret-up");   // up arrow
        disableAction("selection-backward"); // shift-left-arrow
        disableAction("selection-forward");  // shift-right-arrow
        disableAction("selection-up");  //shift-up-arrow
        disableAction("selection-down"); // shift-down-arrow

    }

    private void disableAction(String name) {
        Action a = getActionMap().get(name);
        if (a != null) {
            a.setEnabled(false);
        }
    }