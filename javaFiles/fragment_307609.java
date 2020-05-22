static boolean x(String a) {
    if (a != null && a.equals("Foo"))
        return true;
    else return false;
}

static boolean y(String a) {
    if (a != null) {
        if (a.equals("Foo")) {
            return true;
        } else return false;
    } else return false;
}