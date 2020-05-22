private boolean isAnySelect() {
    for (boolean b : _selection) {
        if (b == true) return true;
    }
    return false;
}