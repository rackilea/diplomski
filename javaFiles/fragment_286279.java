import static java.awt.event.KeyEvent.*;

mainPane.setFocusTraversalKeysEnabled(false);
JRootPane rootPane = mainPane.getRootPane();
InputMap theWIMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
ActionMap theAMap = rootPane.getActionMap();