public class TestCode_Web
{
    public static void main(String[] args) {

    JFrame window = new JFrame("Test");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new BorderLayout());
    window.setSize(400, 400);

    JPanel panelUp = new JPanel();
    JPanel panelUpLeft = new JPanel();
    JPanel panelUpMiddle = new JPanel();

    window.add(panelUp, BorderLayout.NORTH);     
    window.add(panelUpLeft, BorderLayout.WEST);
    window.add(panelUpMiddle, BorderLayout.CENTER);

    JLabel label1 = new JLabel("Label 1");
    JLabel label11 = new JLabel("Label 11");
    JLabel label12 = new JLabel("Label 12");

    panelUp.add(label1);
    panelUpLeft.add(label11);       
    panelUpMiddle.add(label12);     

    panelUp.setBackground(new Color(200, 240, 200));
    panelUpLeft.setBackground(new Color(200, 240, 0));
    panelUpMiddle.setBackground(new Color(100, 240, 200));

    panelUp.setPreferredSize(new Dimension(window.getWidth(), 160));        
    panelUpLeft.setPreferredSize(new Dimension(160, 120));

    window.setVisible(true);
}
}