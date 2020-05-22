class MenuListenerAdapter implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("Menu Selected");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("Menu Deselected");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("Menu Canceled");
    }
}