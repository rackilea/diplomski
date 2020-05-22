private JRadioButton A;
private JRadioButton B;
private JRadioButton C;
private JRadioButton D;
private BufferedImage myPicture;
private JLabel picLabel;

// Constructor
public ExamPrac (){
    A = new JRadioButton("1");
    B = new JRadioButton("2");
    C = new JRadioButton("3");
    D = new JRadioButton("3");
    try {
        myPicture = ImageIO.read(new File("42.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
    } catch (IOException e) {
        // Handle the Exception here
        e.printStackTrace();
    }
    // your other code
}