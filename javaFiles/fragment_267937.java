@Override
public void menuSelected(MenuEvent e) {
    // Put your logic here
    JMenu dynamicMenu = (JMenu) e.getSource();
    dynamicMenu.add(new JMenuItem("MenuItem 1.1.1"));
}

@Override
public void menuDeselected(MenuEvent e) {
    // Remove all MenuItems
    JMenu dynamicMenu = (JMenu) e.getSource();
    dynamicMenu.removeAll();
}

@Override
public void menuCanceled(MenuEvent e) {
    // Remove all MenuItems
    JMenu dynamicMenu = (JMenu) e.getSource();
    dynamicMenu.removeAll();
}