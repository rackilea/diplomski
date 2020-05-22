String n = "nameYouWant";
Variable vFinder(String n) {
    for (v : vars) {
        if v.getName().equals(n) {
            return v;
        }
    }
    return null;
}