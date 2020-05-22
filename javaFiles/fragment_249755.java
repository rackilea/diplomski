void printNames(Component component) {
    System.out.println(component.getName());
    for (Component child : component.getComponents()) {
        printNames(child);
    }
}

void printFrameNamesComponents(JFrame frame) {
    printNames(frame.getContentPane());
}