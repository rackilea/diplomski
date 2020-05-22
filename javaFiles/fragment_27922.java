bool isDouble(string someString) {
    try {
        double d = Convert.ParseInt32(someString);
    } catch(FormatException e) {
        return false;
    }
    return true;
}