InputMap im = getInputMap(JTable.WHEN_FOCUSED_COMPONENT);
ActionMap am = getActionMap();

KeyStroke downKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
KeyStroke upKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);

im.put(downKey, "Action.down");
im.put(upKey, "Action.up");

am.put("Action.down", new DownAction());
am.put("Action.up", new UpAction());