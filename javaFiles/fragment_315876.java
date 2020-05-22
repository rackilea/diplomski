private static NumberPanel current;

...
// create a static MouseListener instead of creating a new one for each
// NumberPanel instance.
private static final MouseAdapter mouseListener = new MouseAdapter(){

    public void mousePressed(MouseEvent event) {
        NumberPanel panel = (NumberPanel) event.getSource(); 
        if(current != null) { 
            current.mouseClicked = false;
        }
        current = panel;
        panel.mouseClicked = true;
        // repaint number panels container
    }
}
...
addMouseListener(mouseListener);