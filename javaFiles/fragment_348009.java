pm.addPopupMenuListener(new PopupMenuListener() {

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {
        System.out.println("cancelled");
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        System.out.println("vanishing");
    }

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        System.out.println("appearing");
    }
});