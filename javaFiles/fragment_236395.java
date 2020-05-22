class ShapeGui extends JFrame{
private JButton[] buttons;
private final String[] butLabel =    {"Red","Green","Blue","Rectangle","Circle","Exit"};
private Container pane;
private JLabel dateLabel;
private int x1,x2,y1,y2;
private Color color;
JTextArea textArea;
ButtonHandler butHandle = new ButtonHandler();
private boolean isRect=true;  //set default draw shape when program run to rectangel
DrawPanel drawPanel= new DrawPanel();

public JPanel drawSpace(){
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BorderLayout());
    leftPanel.setPreferredSize(new Dimension(200,450));

    //create panel for mouse click event
    leftPanel.add(drawPanel, BorderLayout.CENTER);
    MouseHandler mouseHandle = new MouseHandler();
    drawPanel.addMouseListener(mouseHandle);
    drawPanel.addMouseMotionListener(mouseHandle);
    //create date label and format to show only date
    Date today = new Date();  
    dateLabel= new JLabel(today.toString());
    leftPanel.add(dateLabel,BorderLayout.SOUTH); //add date to panel

    return leftPanel;

}


public void drawShape(){
    if(isRect){
    Rectangle rect = new Rectangle(x1,y1,x2,y2,color);
        drawPanel.add(rect);
        drawPanel.repaint();
    }
}

private class ButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj == buttons[0]){
            color=Color.red;
            System.out.println("Color: "+color);
        }
        if(obj == buttons[1]){
            color=Color.green;
            System.out.println("Color: "+color);
        }
        if(obj == buttons[2]){
            color=Color.blue;
            System.out.println("Color: "+color);
        }
        if(obj == buttons[3]){
            isRect=true;
            System.out.println("Boolean Rectangle: "+isRect);
        }
        if(obj == buttons[4]){  //change to false once button circle is clicked
            isRect=false;
            System.out.println("Boolean Rectangle: "+isRect);
        }
        if(obj == buttons[5]){
            //serialization 
            System.exit(0);
        }
    }
}  //end of buttonHandler



class DrawPanel extends JPanel {
Rectangle rect;
private int x1,x2,y1,y2;
Color color;

public DrawPanel() {
}

public void add(Rectangle rect) {
  this.rect=rect;
}

public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(rect.color);
    g.fillRect(rect.x1, rect.y1, rect.x2-rect.x1, rect.y2-rect.y1);
}
}

class Rectangle {
int x1,x2,y1,y2;
Color color;

public Rectangle(int x1, int y1, int x2, int y2, Color color) {
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
    this.color=color;
}
}