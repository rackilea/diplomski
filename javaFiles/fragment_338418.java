JPanel wrapperPanel = new JPanel();
...
InputMap wrapperPanelInputMap = wrapperPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
wrapperPanelInputMap.put(shiftKeyStroke, "pressedAction");
wrapperPanelInputMap.put(shiftReleasedKeyStroke, "releasedAction");
...
wrapperPanel.getActionMap().put("pressedAction", pressedAction);
wrapperPanel.getActionMap().put("releasedAction", releasedAction);