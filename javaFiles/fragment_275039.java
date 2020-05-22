public void buttonSelected(ActionEvent click) {

    Object source = click.getSource();

    if (onePlayer) {

        // User's turn first
        source.setText("O");
        source.setEnabled(false);
        pnlPlayingField.requestFocus();

        // Mark that button as chosen
        for (int i = 0; i < btnNotSelected.length; i++) {
            if (source == btnNotSelected[i]) {
                chosen[i] = true;
                break;
            }
        }

        // Increment turn counter
        turn++;

        // Check if game is over
        if (turn > 9) return;

        // CPU turn
        int selected;
        do {
            selected = new Random().nextInt(btnNotSelected.length);
        } while (chosen[selected]);

        chosen[selected] = true;
        btnNotSelected[selected].setText("X");
        btnNotSelected[selected].setEnabled(false);
        pnlPlayingField.requestFocus();
        turn++;

    } else if (twoPlayer) {
        /* your preexisting twoPlayer code */
    }

}