ButtonIndexPair[][] buttons = new ButtonIndexPair[3][3];


@Override
public void actionPerformed(ActionEvent e) {
    //Using getSource method to avoid multiple if statements and make it efficient
    JButton myButton = (JButton) e.getSource();
    ButtonIndexPair theRightPair = buttons[0][0];
    for (int row = 0; row < buttons.length; row++) {
        for (int col = 0; col < buttons[row].length; col++) {
            if(buttons[row][col].getButton().equals(myButton)){
                theRightPair = buttons[row][col];
                break;
            }
        }
    }

    //then you can use 'theRightPair' 

    if (!check)
        myButton.setText("X");
    ; //Set X to the clicked cell
    if (check)
        myButton.setText("O"); //Set O to the clicked cell
    check = !check; //Reverting the button state 
    myButton.setFont(new Font("Arial", Font.BOLD, 60)); //Set font of X and O
    myButton.setEnabled(false); //Disable button after it gets clicked

 }