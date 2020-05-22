for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++) {
            goldSeat = new JButton();   // button created but never added
            silverSeat = new JButton(); // button created but never added
            bronzeSeat = new JButton(); // button created but never added
            add(new JButton()); // only button added
        }
    this.add(Panel1); // this throws off the whole GridLayout since it's added to the grid