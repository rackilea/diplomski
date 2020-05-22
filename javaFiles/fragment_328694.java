private boolean someMethod() {
    try {
        // do the logic here that might throw the following
        return true;

    } catch (IOException ioe) {
        // handle IOE
    } catch (ClassNotFoundException cnfe) {
        // handle CNFE
    }
    return false;
}