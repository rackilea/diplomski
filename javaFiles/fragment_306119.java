public class Start extends JFrame {
    private static final long serialVersionUID = 1L;

    public Start() {
        Random random = new Random();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Label");

        panel.add(label);
        add(panel);

        this.setVisible(true); //IMPORTANT PART

        while(true){
            int rnd = random.nextInt(4);
            label.setText("" + rnd);
        }
    }
}