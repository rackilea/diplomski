public static void main(String[] args){
    JFrame frame = new JFrame(); 
    JLabel panel = new JLabel(new ImageIcon("cardgameTableCanvas.jpg")); 
    frame.setSize(WIDTH,HEIGHT);
    panel.setSize(WIDTH,HEIGHT);
    frame.add(panel);  
    frame.setTitle("Test Canvas");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CardgameTable sampleTable = new CardgameTable();
    frame.add(sampleTable);
    frame.setVisible(true);
}