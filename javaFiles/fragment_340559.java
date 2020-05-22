BasicSplitPaneUI ui = (BasicSplitPaneUI)splitPane.getUI();
BasicSplitPaneDivider divider = ui.getDivider();
divider.setEnabled( false );

for (MouseListener ml: divider.getListeners(MouseListener.class))
    divider.removeMouseListener( ml );