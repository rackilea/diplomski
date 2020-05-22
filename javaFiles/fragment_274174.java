class Something {
    private final MainPanel mainPanel;

    public Something(MainPanel mainPanel) {
        this.mainPanel = mainPanel; 
    }

    public void myMethod() {
        System.out.printf("Mouse cordinates: %d x %d\n", mainPanel.getX(),
                mainPanel.getY());
    }
}