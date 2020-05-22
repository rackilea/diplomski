Timer timer;
timer = new Timer(33, new ActionListener() {
@Override
public void actionPerformed(ActionEvent ae) {
    // change polygon data
    // ...

    repaint();
}
});
timer.start();