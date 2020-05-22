public class guessHandler implements ActionListener{
    private GUI gui;
    public guessHandler(GUI gui) {
        this.gui = gui;
    }
    public void actionPerformed(ActionEvent e) {
        gui.changePOS(4, 50, 0, 300, 20);
        gui.setError("HI from guessHandler.java");
    }
}