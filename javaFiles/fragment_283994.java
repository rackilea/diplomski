public class ShowImage {
    ImageIcon image = new ImageIcon("D:/java.jpg");
    JLabel label = new JLabel("sdasd", image, JLabel.CENTER);
    JPanel panel = new JPanel(new BorderLayout());

    public ShowImage (){
        panel.add(label, BorderLayout.CENTER);
    }
}