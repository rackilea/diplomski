private static JPanel buildPlayersPanel(int playerSelected) { 

        JPanel createPlayersPanel = new JPanel();
        createPlayersPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        createPlayersPanel.setVisible(true);

        for (int i = 1; i <= playersSelected; i++) {
            final int finalI = i;
            createPlayers[i] = new JTextField("Player " + i + " input name here");
            createPlayers[i].setPreferredSize(new Dimension(160, 20));

            playerNumberText[i] = new JLabel();
            playerNumberText[i].setText("Player " + i);
            playerNumberText[i].setPreferredSize(new Dimension(350, 100));
            playerNumberText[i].setHorizontalAlignment(SwingConstants.CENTER);
            createPlayersPanel.add(playerNumberText[i]);
            createPlayersPanel.add(createPlayers[i]);

            createPlayers[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (createPlayers[finalI].getText().equals("Player " + finalI + " input name here")) {
                        createPlayers[finalI].setText("");
                    }
                }
            });
        }

   return createPlayersPanel;

}