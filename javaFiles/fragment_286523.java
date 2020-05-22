try {
    for (int i = 0; i < limit; ++i) {
        myCharArray[i] = myString.charAt(i);
    }
}
catch (StringIndexOutOfBoundsException ex) {
    // Do you need to treat string indexes differently?
}
catch (ArrayIndexOutOfBoundsException ex) {
    // Perhaps you need to do something else when the problem is the array.
}
catch (IndexOutOfBoundsException ex) {
    // Or maybe they can both be treated equally.
    // Note: you'd have to remove the previous two `catch`.
}