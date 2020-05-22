public void cardClickHandler(ActionEvent ae)
{
    // method variables
    JButton card = (JButton) ae.getSource();
    boolean clearState = false;


    // behavior for first card clicked 
    if (isFirstCard)
    {
        firstCardClicked = card;

        // a known issue with "setDisabledIcon()" required the "setIcon()" method
        firstCardClicked.setIcon(new ImageIcon("images2/img" + firstCardClicked.getName() + ".jpg"));
        firstCardClicked.setDisabledIcon(new ImageIcon("images2/img" + firstCardClicked.getName() + ".jpg"));

        // disable the flipped card
        firstCardClicked.setEnabled(false);

        // indicate the next card clicked is the second card
        isFirstCard = false;
    }
    // behavior for second card clicked
    else
    {
        secondCardClicked = card;

        // a known issue with "setDisabledIcon()" required the "setIcon()" method
        secondCardClicked.setIcon(new ImageIcon("images2/img" + secondCardClicked.getName() + ".jpg"));
        secondCardClicked.setDisabledIcon(new ImageIcon("images2/img" + secondCardClicked.getName() + ".jpg"));

        // disable the flipped card
        secondCardClicked.setEnabled(false);

        // indicate the next card clicked is the first card again
        isFirstCard = true;

        // indicate to the system both cards have been clicked and can clear objects
        clearState = true;
    }

    // behavior if two cards have been clicked and they match
    if (isFirstCard && firstCardClicked.getName().equals(secondCardClicked.getName()))
    {
        // player turn control and scoring
        if (p1Turn)
        {
            p1NumScore++;
            p1Score.setText(Integer.toString(p1NumScore));
            scorePanel.revalidate();
            p1Turn = !p1Turn;
        }
        else
        {
            p2NumScore++;
            p2Score.setText(Integer.toString(p2NumScore));
            scorePanel.revalidate();
            p1Turn = !p1Turn;
        }
    }
    // behavior if two cards have been clicked and they do not match
    else if (isFirstCard && !(firstCardClicked.getName().equals(secondCardClicked.getName())) )
    {
        // enable the cards and reset images
        firstCardClicked.setIcon(BASE_IMAGE);
        secondCardClicked.setIcon(BASE_IMAGE);

        // change turns
        p1Turn = !p1Turn;
    }
    if (clearState)
    {
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                        firstCardClicked.setEnabled(true);
                        secondCardClicked.setEnabled(true);
                        isFirstCard = true;
                        firstCardClicked = null;
                        secondCardClicked = null;

            }
        });

    // Normally the timer's actionPerformed method executes repeatedly. Tell it only to execute once.
    timer.setRepeats(false);

    // Start the timer.
    timer.start();
    }
}