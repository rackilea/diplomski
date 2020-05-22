private void setExitOnKeyStroke(KeyStroke keyStroke) {
        // do your key bindings

        // first get ActionMap and InputMap
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        // then the keystroke
        String key = keyStroke.toString();

        inputMap.put(keyStroke, key); // map the keystroke to a String key
        actionMap.put(key, exitAction); // map the same String key to the Action
    }

    // method that allows outside classes to swap views
    public void showCard(String key) {
        cardLayout.show(this, key);
    }
}