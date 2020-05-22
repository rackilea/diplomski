public void updateField(String node, String element) {
    // receiving the parsed node and its value from the thread
    // and updating it here
    // so it can be displayed on the screen
    //Don't forget to add this next line when called from a thread
    synchronized (UiApplication.getEventLock()) {
        String title = "My App";
        _screen.add(new RichTextField(node + " : " + element));

        if (node.equals(title)) {
            _screen.add(new SeparatorField());
        }
        }
}