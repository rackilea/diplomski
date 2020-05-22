private static boolean anyNotValid(int... values) {
    for(int i: values) {
        if(i < 0 || i > 255) return true;
    }
    return false;
}