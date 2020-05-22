public class Mutil_Image_2 implements MouseListener {


//A JDialog to show your image
public JDialog popup;
//A JPanel to store the last panel that was clicked.
public JPanel lastPane;

public JPanel[][] sub = new JPanel[10][10];
public JPanel screen = new JPanel();

public JFrame f = new JFrame("Draw on Panel");
public static int v1, v2;
public static int x1 = 1, y1 = 1;

public Mutil_Image_2(String title) {
    //Popup that is owned by your JFrame f.
    popup = new JDialog(f);
    //Initial location
    popup.setLocation(0, 0);
    //Initial size same as source in your original code.
    popup.setSize(500, 500);
    //Removes the window controls from the popup to make it look like a JPanel
    //Setting this to false will make the popup look like a JFrame.
    popup.setUndecorated(true);


    //Your original code for drawing all the JPanels
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full Screen

    screen.setBorder(BorderFactory.createLineBorder(Color.black));
    screen.setLayout(new GridLayout(10, 10));

    int dem = 0;
    for (int i = 0; i <= 9; i++) {
        for (int j = 0; j <= 9; j++) {
            sub[i][j] = new JPanel();
            sub[i][j].setBorder(BorderFactory.createLineBorder(Color.red));
            screen.add(sub[i][j]);

            v1 = i;
            v2 = j;
            sub[i][j].addMouseListener(this);
            f.add(screen);
        }

    }
    f.pack();
    f.setVisible(true);
}

public static void main(String args[]) {
    new Mutil_Image_2("Grid Layout");
}

public void mouseClicked(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}

public void mousePressed(MouseEvent e) {
    JPanel source = (JPanel) e.getSource();
    BufferedImage img1;



    if (e.getButton() == MouseEvent.BUTTON1) {

        //Close the popup if the same panel was clicked twice
        if(lastPane != null){
            if(lastPane.equals(source)){
                popup.setVisible(false);
                lastPane = null;
                return;
            }
        }
        //If the above test was false we are clicking a different panel
        //assign this panel to lastPane so we can close the popup if
        //this pane is clicked again
        lastPane = source;

        //We now get the position of the click in the frames coordinates
        //Using e.getX/Y will return the click in panel coordinates, we don't want
        //that as we are positioning the popup relative to the JFrame.
        x1 = f.getMousePosition().x;
        y1 = f.getMousePosition().y;

        //Position the popup on the mouse click
        popup.setLocation(x1, y1);

        //Old code
        //x1 = e.getX();
        //y1 = e.getY();
        // source.setBackground(Color.black);
        //source.setSize(500, 500);

        try { // The first way to show Image
            img1 = ImageIO.read(new File("D:\\Pict3.png"));
            JLabel picLabel = new JLabel(new ImageIcon(img1));

            //Remove any components in the popups content pane
            //this essemntially gives up a fresh panel inside
            //the popup.
            popup.getContentPane().removeAll();
            //add picture to popup
            popup.add(picLabel);
            //show popup
            popup.setVisible(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}