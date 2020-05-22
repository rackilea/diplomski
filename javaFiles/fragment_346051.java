for (Window w : Window.getWindows()) {
    SwingUtilities.updateComponentTreeUI(w);
    if (w.isDisplayable() &&
        (w instanceof Frame ? !((Frame)w).isResizable() :
        w instanceof Dialog ? !((Dialog)w).isResizable() :
        true)) w.pack();
}