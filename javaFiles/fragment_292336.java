public static void setCheckable(BottomNavigationView view, boolean checkable) {
    final Menu menu = view.getMenu();
    for(int i = 0; i < menu.size(); i++) {
        menu.getItem(i).setCheckable(checkable);
    }
}