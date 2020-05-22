int[][] characters = new int[][] {
                {'?', '%', '~', '|'},
                {' ', ',', '-', '.', '/'},
                {';', '=', '[', '\\', ']'}, 
                {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'*', '+', ',', '-', '.', '/', '&', '*', '\"', '<', '>', '{', '}', '`', '\''},
                {'@', ':', '^', '$', '!', '(', '#', '+', ')', '_'}
                // if you're so inclined: add even more rows to the bottom
                ,{'¡', '€', '\u02ff'}
};

for(int[] range : characters) 
    for(int i = 0; i < range.length; i++) {
        char charForKey = (char)range[i];
        KeyStroke keyboardKey = KeyStroke.getKeyStroke(charForKey);
        theWIMap.put(keyboardKey, charForKey);
        theAMap.put(charForKey, new KeyAction(charForKey));
    }