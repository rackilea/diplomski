// pass the comboBox.getValue() to the third parameter
private void validateTable(GridPane table, Button button, int numRows) {

   for(Node textField : table.getChildren()){ 
      if(textField instanceof TextField){
         ((TextField)textField).textProperty().addListener((obs, old, newV)->{
           // first of all remove the red border from the invalid TextField (if any)
          // we know that via textFieldIndex which should be -1 if there is no lesser
          // actually it's a pain 
          if(textFieldIndex!=-1){
            ((TextField) getComponent(textFieldIndex, 3, table)).setStyle("");
          }
          if(isAllFilled(table)){ // if all filled ( you already have this method)
             if(hasValidValue(table,numRows)){ // check for validity
                button.setDisable(false); // then make the button active again
             }
             else{// if it's not a valid value
                  // re-style the TextField which has lesser value
                 ((TextField) getComponent(textFieldIndex, 3, table)).
                                        setStyle("-fx-border-color: red;");
                  button.setDisable(true); 
             }
          }
          else{
               button.setDisable(true);
          }
       });
     }  
   }
}