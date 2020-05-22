// Use WindowAdapter if you don't want to implement the rest of the methods
// otherwise use new WindowListener()
window.addWindowListener( new WindowAdapter() { 
    @Override
    public void windowClosing(WindowEvent e) {
        stop();
    }});