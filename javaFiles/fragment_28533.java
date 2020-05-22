public class testframe extends JFrame {

private JPanel contentPane;
String panel = "Card with JButtons";
String panel2 = "Card with JTextField";
JPanel cards = new JPanel();
JPanel card1 = new JPanel();
JPanel card2 = new JPanel();
/**
 * Create the frame.
 */
public testframe() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel();
    setContentPane(contentPane);  

    cards = new JPanel(new CardLayout());
    card1 = new JPanel();
    card2 = new JPanel();

    JButton b1 = new JButton("button 1");
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, panel2); 
        }
    });
    card1.add(b1);

    JButton b2 = new JButton("button 2");
    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, panel);
        }
    });
    card2.add(b2);      

    cards.add(card1, panel);
    cards.add(card2, panel2);



    contentPane.add(cards);

}