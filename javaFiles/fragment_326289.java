public void setSquare(JButton button) {
        if (player) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        button.removeActionListener(lfb);
        player = !player;
    }