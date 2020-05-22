for (byte row = 0; row < 8; row++) {
        for (byte col = 0; col < 8; col++) {
            shinyButtons[row][col] = new JButton();
            shinyButtons[row][col].setLocation(10 + col * 69, 10 + row * 69);
            shinyButtons[row][col].setSize(69, 69);
            getContentPane().add(shinyButtons[row][col]);
        }
    }

    reset();