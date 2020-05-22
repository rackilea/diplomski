public void doThings() {
    area.setText("Start, ");
    // Want program to wait for two seconds
    waitForTwoSeconds();

}

public void waitForTwoSeconds() {

    timer = new Timer(2000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            area.append("Finished Waiting, ");
            area.append("Finished ");
            timer.stop();
        }
    });
    timer.setRepeats(false);
    timer.start();
}