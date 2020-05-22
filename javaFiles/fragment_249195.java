//Any component that is always visible in the window (like the image)
JComponent c;
//Get input and action map
InputMap imap = c.getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap amap = c.getActionMap();
//Put keybinding and action
imap.put(KeyStroke.getKeyStroke("shift D"), "doSomething");
amap.put("doSomething", anAction);