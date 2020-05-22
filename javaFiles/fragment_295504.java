public void actionPerformed(ActionEvent e) {

    String text = Input.getText();

    switch (text) {
        case "green":
            color.setBackground(Color.GREEN);
            break;
        case "red":
            color.setBackground(Color.RED);
            break;
        case "yellow":
            color.setBackground(Color.YELLOW);
            break;
        case "blue":
            color.setBackground(Color.BLUE);
            break;

    }

}