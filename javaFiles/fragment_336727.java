public static class FocusDebugger implements FocusListener {
    private final String name;

    public FocusDebugger(String name) {
        this.name = name;
    }

    public void focusGained(FocusEvent focusEvent) {
        System.out.println(name + ".focusGained");
    }

    public void focusLost(FocusEvent focusEvent) {
        System.out.println(name+".focusLost");
    }
}