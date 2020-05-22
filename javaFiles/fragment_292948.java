class apple1 extends Frame implements ActionListener {

private Button b;

TextField tf;
JTextArea lbl;
int count = 0;

public apple1() {

    tf = new TextField("Points: ");
    tf.setBounds(10, 30, 140, 20);

    //create components   
    b = new Button("RED");
    b.setBackground(Color.red);
    b.setBounds(80, 260, 80, 30);

    Button b2 = new Button("BLUE");
    b2.setBackground(Color.blue);
    b2.setBounds(180, 260, 80, 30);

    //register listener
    b.addActionListener(this);//passing current instance  

    //add components and set size, layout and visibility  
    add(tf);
    add(b);
    add(b2);
    setSize(600, 600);
    setLayout(null);
    setVisible(true);
}

public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Color[] clrs = {Color.red, Color.blue};
    Random rand = new Random();
    g2.setColor(clrs[rand.nextInt(clrs.length)]);
    g2.fillRect(60, 50, 200, 200);
    if (g2.getColor().equals(b.getBackground())) {
        tf.setText(String.valueOf(count++));
    }
}

public void actionPerformed(ActionEvent e) {
    repaint();
}

public static void main(String args[]) {
    new apple1();
}
}