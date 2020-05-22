InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
ActionMap am = table.getActionMap();

KeyStroke tabKey = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);

Action moveNextCellAction = am.get(im.get(tabKey));

ContinousEditAction continousEditAction = new ContinousEditAction(table, moveNextCellAction);

im.put(tabKey, "Action.tab");

am.put("Action.tab", continousEditAction);