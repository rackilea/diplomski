public JPanel createScorePanel(){

    JPanel scorePanel = new JPanel();

    JPanel[] columns;
    columns = new JPanel[3];

    JLabel[] player1score;
    player1score = new JLabel[22];

    JLabel[] playerNames;
    playerNames = new JLabel[2];

    playerNames[0] = new JLabel(player1);
    playerNames[1] = new JLabel(player2);

    columns[0] = new JPanel();
    columns[0].setSize(200, 540);
    columns[0].setLayout(new GridLayout(22,0));

    for (int count = 1; count <= (playerNames.length) ; count++ ){
        columns[count] = new JPanel();
        columns[count].setSize(150,540);
        columns[count].setLayout(new GridLayout(22,1));

        for (int i = 0; i < player1score.length; i++){
            if (count == 1 && i == 0) {
                player1score[i] = new JLabel(player1);
                player1score[i].setBorder(new MatteBorder(1, 1, 1, 1, Color.GREEN));
                columns[count].add(player1score[i]);
            }
            else if (count == 2 && i == 0) {
                player1score[i] = new JLabel(player2);
                player1score[i].setBorder(new MatteBorder(1, 1, 1, 1, Color.GREEN));
                columns[count].add(player1score[i]);
            }
            else {
                player1score[i] = new JLabel();
                player1score[i].setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                columns[count].add(player1score[i]);
            }
        }
        scorePanel.add(columns[count]);
    }
    return scorePanel;
}