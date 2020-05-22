int[][] commands = new int[][] {
        {VK_BACK_SPACE, VK_ENTER, VK_ESCAPE},
        {VK_PAGE_UP, VK_PAGE_DOWN, VK_END, VK_HOME}, 
        {VK_LEFT, VK_UP, VK_RIGHT, VK_DOWN,  VK_DELETE},
        {VK_KP_UP, VK_KP_DOWN, VK_KP_LEFT, VK_KP_RIGHT},
    };
    for(int[] range : commands)
        for(int i = 0; i < range.length; i++) {
            KeyStroke keyboardKey = KeyStroke.getKeyStroke(range[i], 0);
            String commandForKey = KeyEvent.getKeyText(range[i]).toLowerCase();
            theWIMap.put(keyboardKey, commandForKey);
            theAMap.put(commandForKey, new KeyAction(commandForKey));
        }

    theWIMap.put(KeyStroke.getKeyStroke("pressed " + "TAB"), "tab");
    theAMap.put("tab", new KeyAction("tab"));

    theWIMap.put(KeyStroke.getKeyStroke("shift pressed " + "TAB"), "shift tab");
    theAMap.put("shift tab", new KeyAction("shift tab"));