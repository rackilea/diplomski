public JPanel getPanel(BufferedImage image, int count){
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, 1));//0 is horizontal, 1 is vertical
    int columns = (int)Math.ceil(Math.sqrt(count));
    int rows = (int)Math.ceil((double)count / (double)columns);
    int imageHeight = image.getHeight();
    int imageWidth = image.getWidth();
    int buttonWidth = imageWidth / columns;
    int buttonHeight = imageHeight / rows;
    int index = 0;
    for(int row = 0; row < rows; row++){
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(panel, 0));
        for(int column = 0; column < columns; column++){
            if(index >= count){
                break;
            }
            int x = buttonWidth * column;
            int y = buttonHeight * row;
            int width = buttonWidth;
            int height = buttonHeight;
            ImageButton button = new ImageButton(--Insert Problem--,image, x,y,width,height);
            smallPanel.add(button);
        }
        panel.add(smallPanel);
        index++;
    }
    return panel;
}