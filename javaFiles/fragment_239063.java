private static void printMenu(JMenuBar menuBar) {
    for (int i = 0; i < menuBar.getMenuCount(); ++i) {
        printMenu(menuBar.getMenu(i), 0);
    }
}

private static void printMenu(JMenuItem menuItem, int level) {
    for (int i = 0; i < level; ++i) {
        System.out.print("\t");
    }

    System.out.println("\\" + menuItem.getText());

    if (menuItem instanceof JMenu) {
        JMenu menu = (JMenu) menuItem;

        Component[] menuComponents = menu.getMenuComponents();

        for (Component component : menuComponents) {
            if (component instanceof JMenuItem) {
                printMenu((JMenuItem) component, level+1);
            }
        }
    }
}