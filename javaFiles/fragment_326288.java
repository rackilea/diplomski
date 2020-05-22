public void resetBoard() {
        // Fixed the loop index. Was: (int i = 1; i <= b.length - 1; i++)
        for (int i = 0; i < b.length; i++) {
            b[i].setText("");
            // Adding a listener only if there isn't one already
            if (b[i].getActionListeners().length < 1) 
                b[i].addActionListener(lfb);
        }
        player = true;
    }