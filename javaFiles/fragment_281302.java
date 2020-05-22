public boolean shouldYieldFocus(JComponent input) {
    boolean isDataValid =  verify(input);

    if(isDataValid); //do stuff

    return isDataValid; // if verify is true(valid) return true;
 }