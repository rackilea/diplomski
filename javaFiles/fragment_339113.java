public class ButtonHandler implements ActionListener {
    ColoredWordsExperiment coloredWords;
    public ButtonHandler(ColoredWordsExperiment coloredWords) {
        this.coloredWords = coloredWords;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Matching")) {
            System.out.println("Matching");
            coloredWords.label1.setText("Text changed");
        }
    }
}