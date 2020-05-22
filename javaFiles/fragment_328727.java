void createButtons() {
        JButton[][] buttons = new JButton[3][9];
        int index = 1;  //start from 1.jpg
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(new ImageIcon( (index++) + ".jpg"));
            }
        }
    }