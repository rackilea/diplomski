public static TabPane findEnclosingTabPane(Node n) {
    while (n != null && !(n instanceof TabPane)) {
        n = n.getParent();
    }
    return (TabPane) n;
}