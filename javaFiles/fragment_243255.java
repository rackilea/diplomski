mainpanel.setLayout(new GridLayout(25,25,1,1));
JButton buttons[][] = new JButton[25][25];
Image image = ImageIO.read(getClass().getResource("wall_down_right_player.png"));
for(int i=0; i<25; i++){
    for(int j=0; j<25; j++){
        JButton button = new JButton();
        button.setIcon(new ImageIcon(image));
        buttons[i][j]= button;
        mainpanel.add(buttons[i][j]);
    }   
}