public static void main(String[] args) {
    // just example input
    String[][] menuHierarchies = {
            {"New", "Job", "Item A"},
            {"New", "Job", "Item B"}, 
            {"New", "Search", "Item C"},
            {"New", "Item D"},
            {"Other", "Item E"},
            {"New", "Job", "Item B"}, 
            {"Other", "Job", "Item B"}
    };

    JMenuBar menuBar = new JMenuBar();

    // relevant code from here. It builds the menu removing redundancies
    for (int rootIndex = 0; rootIndex < menuHierarchies.length; ++rootIndex) {
        JMenu parentMenu = null;

        for(int menuLevel = 0; menuLevel < menuHierarchies[rootIndex].length; ++menuLevel) {
            // if it is root menu
            if (menuLevel == 0) {
                // checks if the root menu already exists 
                for (int i = 0; i < menuBar.getMenuCount(); ++i) {
                    if (menuBar.getMenu(i).getText().equals(menuHierarchies[rootIndex][menuLevel])) {
                        parentMenu = menuBar.getMenu(i);
                        break;
                    }
                }

                if (parentMenu == null) {
                    parentMenu = new JMenu(menuHierarchies[rootIndex][menuLevel]);
                    menuBar.add(parentMenu);
                }
            } else if (menuLevel < menuHierarchies[rootIndex].length - 1) { // if it is a non-leaf (and, of course, not a root menu)
                Component[] menuComponents = parentMenu.getMenuComponents();
                JMenu currentMenu = null;

                // checks if the menu already exists 
                for (Component component : menuComponents) {
                    if (component instanceof JMenu) {
                        if (((JMenu) component).getText().equals(menuHierarchies[rootIndex][menuLevel])) {
                            currentMenu = (JMenu) component;
                            break;
                        }
                    }
                }

                if (currentMenu == null) {
                    currentMenu = new JMenu(menuHierarchies[rootIndex][menuLevel]);
                    parentMenu.add(currentMenu);
                }

                parentMenu = currentMenu;
            } else { // if it is a leaf
                Component[] menuComponents = parentMenu.getMenuComponents();
                JMenuItem currentItem = null;

                for (Component component : menuComponents) {
                    if (component instanceof JMenuItem) {
                        if (((JMenuItem) component).getText().equals(menuHierarchies[rootIndex][menuLevel])) {
                            currentItem = (JMenuItem) component;
                            break;
                        }
                    }
                }

                if (currentItem == null) {
                    parentMenu.add(new JMenuItem(menuHierarchies[rootIndex][menuLevel]));
                }
            }
        }
    }
}