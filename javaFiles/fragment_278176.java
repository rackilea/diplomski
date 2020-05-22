public class TimeListener implements ActionListener {

    public void actionPerformed(ActionEvent t) {
        currentTime--;
        if (currentTime <= ENDING_TIME) {
            dispose();
            timer.stop();
        }
    }
}