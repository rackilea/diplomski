public static void main (String [] args){
    JFrame frame = new JFrame("test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    JLabel label1= new JLabel("");
    panel.add(label1);    //Add label to panel
    frame.add(panel);     //Add panel (with label) to frame 
    frame.pack();         //Let the frame adjust its size based on the added components
    frame.setVisible(true);
}