JRadioButton p1Scissors = new JRadioButton("Scissors");
 JRadioButton p1Paper = new JRadioButton("Paper");
 JRadioButton p1Rock = new JRadioButton("Rock");
 // group them

 JRadioButton p2Scissors = new JRadioButton("Scissors");
 JRadioButton p2Paper = new JRadioButton("Paper");
 JRadioButton p2Rock = new JRadioButton("Rock");
 // group them

 JLabel statusLabel = new JLabel(" ");

 JButton checkWinner = new JButton("Check Winner"); // You can add to bottom panel

 checkWinner.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
         if (p1Scissors.isSelected() && p2Rock.isSelected()){
             statusLabel.setText("Player 2 wins: Rock beats Scissors");
         } else if ( ..... ) {
             ...
         }

         ...
     }
 });