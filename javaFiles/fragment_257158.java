public void add(String name) {
    synchronized (name) {
        names.add(name);
    }
}

public String removeFirst() {
    synchronized (name) {
        if (names.size() > 0)
            return (String) names.remove(0);
        else
            return null;
    }
}