Action action = new AbstractAction("Do It") { ... };

// This is the component we will register the keyboard shortcut with.
JPanel pnl = new JPanel();

// Create KeyStroke that will be used to invoke the action.
KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);

// Register Action in component's ActionMap.
pnl.getActionMap().put("Do It", action);

// Now register KeyStroke used to fire the action.  I am registering this with the
// InputMap used when the component's parent window has focus.
pnl.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Do It");