interface NameListener {
    public void nameChanged(String newName);
}

class Login {
    private String meno;
    private Collection<NameListener> listeners = new ArrayList<>();
    public void addListener(NameListener l) { listeners.add(l); }
    public void setMeno(String n) {
        meno = n;
        for (NameListener l : listeners) { l.nameChanged(n); }
    }
}