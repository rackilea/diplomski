timer = new Timer(0, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (i > a.length) { // check when to stop
            timer.stop();
            return;
        }

        point = point + arr[i].length();
        doc.setCharacterAttributes(0, point + 1, textpane.getStyle("Red"), true);
        i++;

        // Change delay period
        timer.setDelay(a[i]);
    }
});
timer.setDelay(a[0]);
timer.start();