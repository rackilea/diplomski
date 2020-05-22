public void actionPerformed (ActionEvent e) {
    ...
    if (command.equals("Bulgaria")){
        displayTop.setBackground(Color.WHITE);
        displayCenter.setBackground(new Color(19,138,19));
        displayBottom.setBackground(Color.RED);
        display.setLayout(new GridLayout(1, 3));
    }
    else {
        display.setLayout(new GridLayout(3, 1));
    }
    display.doLayout();