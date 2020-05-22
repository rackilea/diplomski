public class TimeListener implements ActionListener {

    public void actionPerformed(ActionEvent t) {

        System.out.println(">> currentTime = " + currentTime + "; STARTING_TIME = " + STARTING_TIME);
        while (currentTime >= STARTING_TIME) {
            currentTime--;
        }
        System.out.println("<< currentTime = " + currentTime + "; STARTING_TIME = " + STARTING_TIME);
        if (ENDING_TIME == 0) {
            dispose();
        }
    }
}