public class UniversalFindAction extends AbstractAction {
  public void actionPerformed(ActionEvent ae) {
    JTextComponent c = (JTextComponent) ae.getSource();
    showFindDialog(c);
  }
}

// registering of action
JTextComponent comp = new JTextArea();
comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK), "Find");
comp.getActionMap().put("Find", new UniversalFindAction());