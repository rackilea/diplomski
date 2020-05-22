public SessionViewContextMenu(ViewPart sessionView, TableViewer viewer,
final Action action) {

MenuManager manager = new MenuManager("#PopupMenu");

manager.setRemoveAllWhenShown(true);
manager.addMenuListener(new IMenuListener() {

    public void menuAboutToShow(IMenuManager manager) {
        manager.add(action);

        // submenu for a specific user
        MenuManager subMenu = new MenuManager("Change Status", null);

        // Actions for the sub menu
        subMenu.add(someAction);

        // add the action to the submenu
        manager.add(subMenu);
    }
});