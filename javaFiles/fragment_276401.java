private void lowerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            

            playedGame = game.chooseLow();

                if(playedGame == true) { // maybe not best wording, as check is gameOver = true
                    score.setText("---");
                    cardIMG = card.getCardBackImage();
                    scaledCard = cardIMG.getScaledInstance( 90, 138,  java.awt.Image.SCALE_SMOOTH ) ;
                    cardImage.setIcon(new ImageIcon(scaledCard));             
                    lowerButton.setVisible(false);
                    higherButton.setVisible(false);
                    text_or.setVisible(false);
                    restartButton.setVisible(true);
                    currentCard.setText(game.getCurrentCard().toString() + " [" + game.getCurrentCard().getCardIntValue() + "]" + "final score: " + game.getCurrentScore());
                }
                else {
                    score.setText(game.getCurrentScore() + "");
                }

            Card card = game.getCurrentCard();        
            BufferedImage cardIMG = card.getCardImage();
            Image scaledCard = cardIMG.getScaledInstance( 90, 138,  java.awt.Image.SCALE_SMOOTH ) ;
            cardImage.setIcon(new ImageIcon(scaledCard));               
            currentCard.setText(game.getCurrentCard().toString() + " [" + game.getCurrentCard().getCardIntValue() + "]");    
        }