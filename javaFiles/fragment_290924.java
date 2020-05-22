class JFrameA extends JFrame {
    ObservableB b;

    public void add() {
        ObserverC c = new ObserverC(b);
    }
}

class ObservableB extends Observable {

}

class ObserverC extends JFrame implements Observer {

    public ObserverC(final Observable observable) {
        // observer is added
        observable.addObserver(this);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent arg0) {
                // observer is deleted
                observable.deleteObserver(ObserverC.this);
            }
        });
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        ...
    }
}