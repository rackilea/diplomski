for(char c = 'A'; c <= 'Z'; c++) {
    // upper case
    KeyStroke capital = KeyStroke.getKeyStroke("typed " + c);
    theWIMap.put(capital, Character.toString(c));
    theAMap.put(Character.toString(c), new KeyAction(c));

    // lower case
    KeyStroke little = KeyStroke.getKeyStroke("typed " + Character.toLowerCase(c));
    theWIMap.put(little, Character.toString(Character.toLowerCase(c)));
    theAMap.put(Character.toString(Character.toLowerCase(c)), new KeyAction(Character.toLowerCase(c)));
}