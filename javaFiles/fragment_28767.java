SwingUtilities.invokeLater(new Runnable() {

    public void run() {
        menuB.setPopupMenuVisible(true);
        MenuSelectionManager.defaultManager().setSelectedPath(new MenuElement[]{popup, menuB, menuY});
    }
});