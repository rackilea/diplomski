interface MenuListener {
    public void menuClicked(Menu m);
    // other type of handlers here, when menu state changes e.g. menuExpanded()
}

public class Menu {
    ...
    List<MenuListener> listeners = new ArrayList<MenuListener>();

    // this method will be called internally by each menu when it detects
    // that its state changed
    private void notifyListeners() {
        for (MenuListener listener : listeners) {
            // let all the listeners know this menu was clicked
            listener.menuClicked(this);
        }
    }
}    

// now when menu is created assign a listener to it
Menu item = new Menu(...);
item.addMenuListener( new MenuListener () {
    public void menuClicked(Menu m) {
        // do something with item here
    }
});