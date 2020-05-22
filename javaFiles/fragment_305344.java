public class StartHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("START Pressed");
        startButton.setText("Reset");
        repaint();
        runAnimation();
        startButton.setText("Start");
    }
}