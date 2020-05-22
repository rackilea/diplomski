class MyTreeSet extends TreeSet<String> {

    public String toString() {
        StringBuilder asString = new StringBuilder();
        for (String s : this) {
            if (asString.length() > 0) {
                asString.append("\n");
            }
            asString.append(s);
        }
        return asString.toString();
    }
}