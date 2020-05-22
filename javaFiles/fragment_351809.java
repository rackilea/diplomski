private void loadTileContainer(){
    tileContainer = new JPanel(new GridLayout(20,20));
    tileContainer.setBackground(Color.LIGHT_GRAY);
    tileContainer.setBounds(0, 0, width - 15, height - 200);
    tileContainer.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

    if(toggleGrid){
        System.out.println("Working");
        for(int i = 0; i < 400; i++){
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tileContainer.add(label);
        }
    }

    contentPane.add(tileContainer);
}