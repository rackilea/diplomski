protected Object[] getPrimaryKeysFromGoogleKey(String key) {
    //creates an array with only one value so keyValuesAsText.length is always 1 
    String[] keyValuesAsText = new String[] { key };

    //sames as Object[] keyValues = new Object[1];
    Object[] keyValues = new Object[keyValuesAsText.length];

    //sets the first value of the keyValues array to the Integer.parseInt(key);
    keyValues[0] = new Integer(keyValuesAsText[0]);

    //the entire method could be replaced with the following line:
    //return new Object[] { new Integer(key) };    
    return keyValues;
}