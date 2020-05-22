public void actionPerformed(ActionEvent e) {
    …
    if (index == iterations) {
        timer.stop();
        loop.exit ();
        …
    }
}