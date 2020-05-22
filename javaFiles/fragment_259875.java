state = 0 // state is initialized to 0
label1.setText("How many Submarines would you like");
button1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
         switch(getState()){
              case 0:
                    //Your How-many-submarines logic goes here

                    label1.setText("How many Friggates would you like");
                    setState(1);
                    break;
              case 1:
                    // Your how-many-friggates logic goes here
                     label1.setText("How many Battleships would you like");
                     setState(2);
                     break;

              case 2:
                    // Your how-many-battleships logic goes here
                    label1.setText("Done");
                    setState(3);
                    break;

              case 3:
                    System.out.println("Done");

         }
    }
});