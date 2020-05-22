public class RealEstate extends JFrame {

    protected JButton zz = null;

    RealEstate() {
        JLabel l = new JLabel("Label");
        l.setBounds(100, 50, 300, 250);
        add(l);

        // ImageIcon ss = new ImageIcon("path_to_image_file");
        zz = new JButton("MyButton");
        zz.setBounds(470, 70, 35, 35);
        zz.setBackground(new Color(0, 170, 120));
        add(zz); 
    }
}