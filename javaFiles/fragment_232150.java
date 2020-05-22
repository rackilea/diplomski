public class View implements ActionListener, Observer {

    public View(Model m) {
            // snip
            m.addObserver(this);
    }

    public void     update(Observable o, Object arg) {
        // Delegate to previously defined method
        update();
    }

}