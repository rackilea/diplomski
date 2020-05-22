private class DisposeAction extends AbstractAction {
  private static final long serialVersionUID = 1L;
  public DisposeAction(String name, int mnemonic) {
     super(name); // set button's text
     putValue(MNEMONIC_KEY, mnemonic); // set it's mnemonic key
  }

  @Override
  public void actionPerformed(ActionEvent e) {
     // get the button that caused this action
     Object source = e.getSource();
     if (source instanceof AbstractButton) {
        AbstractButton exitButton = (AbstractButton) source;

        // get the parent top level window
        Window topWindow = SwingUtilities.getWindowAncestor(exitButton);
        if (topWindow == null) { // if null, then likely in a JMenuItem
           // so we have to get its jpopupmenu parent
           Container parent = exitButton.getParent();
           if (parent instanceof JPopupMenu) {
              JPopupMenu popupMenu = (JPopupMenu) parent;

              // get the invoker for the pop up menu
              Component invoker = popupMenu.getInvoker();
              if (invoker != null) {
                 // and get *its* top level window
                 topWindow = SwingUtilities.getWindowAncestor(invoker);
              }
           }
        }
        if (topWindow != null) {
           // dispose of the top-level window
           topWindow.dispose();
        }
     }
  }
}