@Override
public void actionPerformed(ActionEvent e) {
  JTextComponent c = getFocusedComponent();
  if (s.equals("Find")) {
    Action a = c.getActionMap().get("Find");
    if (a.isEnabled()) {
      // generate new event to modify the source (menu item -> text component)
      ActionEvent ae = new ActionEvent(c, e.getID(), e.getCommand());
      a.actionPerformed(ae);
    }
  }
}