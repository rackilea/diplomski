timer = new Timer(
                500, new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        scoreTextField.setText("" + game.getScore());
                        int scoreForLevelUpdate = game.getScoreForLevelUpdate();
                        if (scoreForLevelUpdate >= Tetris.PER_LEVEL_SCORE && scoreForLevelUpdate > 0)
                            game.levelUpdate();
                    }
                }
        );

        timer.start();