in myJPanel
   public class myJPanel extends JPanel implements ActionListener {

   ImageIcon img; //declare 

public myJPanel(){
    super();
    setBackground(Color.white);
    setLayout (new BorderLayout());
    credits = new credits();
    instructions = new instructions();
    characterTheme = new characterTheme();
    img = new ImageIcon("images/pennmap.jpg");//grab from images foler.