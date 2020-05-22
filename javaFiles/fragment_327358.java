while(true){
      String userInput=JOptionPane.showInputDialog(null," Enter Positive Number");
        if(userInput.matches("^\\d+(.\\d+)?$")){
         double numberOfmiles=Double.parseDouble(userInput);
         if (numberOfmiles <0){
        JOptionPane.showMessageDialog(null, "Warning, enter positive numbers only")
        }
        else{
        //successful input
        break;
        }
    }
        else{
            JOptionPane.showMessageDialog(null, "Just positive numbers are allowed"); 
        }

   }