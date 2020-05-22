public class JavaApplication5 {

    public static void main(String[] args) {
JFrame f = new JFrame("Traffic Light");
f.add(new TrafficLight());
f.setSize(500, 500);
f.setVisible(true);
    }
}

 class TrafficLight extends JPanel implements ActionListener {

   private Button lightRed, lightYellow, lightGreen;
private JPanel panel1;
private boolean lightRedClicked = false, lightYellowClicked = false, lightGreenClicked = false;
public TrafficLight(){
    setLayout(new BorderLayout());
    panel1 = new JPanel();

    lightGreen = new Button("Go");
    lightYellow = new Button("Wait");
    lightRed = new Button("Stop");
    panel1.add(lightRed);
    panel1.add(lightYellow);
    panel1.add(lightGreen);

    add(panel1, BorderLayout.NORTH);
    lightRed.addActionListener(this);
     lightGreen.addActionListener(this);
      lightYellow.addActionListener(this);
}
public void init() {


}
public void paint(Graphics g){
    setBackground(Color.cyan);
    g.setColor(Color.black);
    g.fillRect(260,50,80,160);
    g.setColor(new Color(255, 150, 150));     //light red
    g.fillOval(280,60,40,40);
    g.setColor(new Color(255, 255, 200));     //light yellow
    g.fillOval(280,110,40,40);
    g.setColor(new Color(150, 200, 150));      //light green
    g.fillOval(280,160,40,40);

    if(lightRedClicked == true){           
        g.setColor(Color.red);
        g.fillOval(280,60,40,40);
        lightRedClicked = false;
    }
    if(lightYellowClicked == true) {
        g.setColor(Color.yellow);
        g.fillOval(280,110,40,40);
        lightYellowClicked = false;
    }

    if(lightGreenClicked == true) {
        g.setColor(Color.green);
        g.fillOval(280,160,40,40);
        lightGreenClicked = false;
    }
}
public void actionPerformed(ActionEvent swicth) {  
    if(swicth.getSource() == lightGreen){
    lightGreenClicked = true;
    repaint();
    }
    if(swicth.getSource() == lightYellow){
    lightYellowClicked = true;
    repaint();
    }
    if(swicth.getSource() == lightRed){
    lightRedClicked = true;
    repaint();
    } 
}


}