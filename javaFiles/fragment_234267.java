public class Franels extends MouseAdapter {

    //...
    JPanel panel = new JPanel();

    // Just want to point out that these method names
    // are poorly chosen
    public void JFrame(int width, int height) {
        //...
        // Thi sis going to give you no end of issues
        frame.setLayout(null);
        //...
        frame.add(panel);
        //...
    }

    // This is never called
    public void JPanel() {
        panel.setBounds(300, 300, 300, 300);
        panel.setBackground(Color.blue);
        panel.setVisible(true);

        panel.add(label);        
    }


    //...
}