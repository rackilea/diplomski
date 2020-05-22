public String officeLoc () {
    if (...) {
        String tempLoc = ...;
    } else {
        String tempLoc = ...;
    }
    return tempLoc; // <- can't do this, tempLoc is out of scope
}