public void hierarchyChanged(HierarchyEvent e) {
    Window win = SwingUtilities.getWindowAncestor(this);
    if ((win != null) && (!win.equals(topLevelWindow))) {
        topLevelWindow = win;
        topLevelWindow.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }

        });
    }
}

private void handleWindowClosing() {
    if (table.isEditing()) {
        table.getCellEditor().cancelCellEditing();
    }
}