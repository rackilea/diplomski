public void addScreen(String name, Node screen) {
    screens.put(name, screen);
    AnchorPane.setTopAnchor(screen, 0d);
    AnchorPane.setRightAnchor(screen, 0d);
    AnchorPane.setBottomAnchor(screen, 0d);
    AnchorPane.setLeftAnchor(screen, 0d);
}