public void setNumbers() {
    //gridpane does not have a method to access the value of a node in the
    //gridpane, so I will store the values in an array.
    valList = new int[10][10];
    for (int i = 0; i < 10; i++) {
        for (int k = 0; k < 10; k++) {
            TextField tf = new TextField();
            tf.setPrefWidth(25);
            //set the value of the text field to 0 or 1
            //create a random 0 or 1 integer
            int val = (int)(rint(Math.random()));
            //fill the array with the values
            valList[i][k] = val;
            String valStr = String.valueOf(val);
            tf.setText(valStr);
            //add text fields to gridpane
            GridPane.setConstraints(tf, k, i);
            gp1.getChildren().add(tf);

            tf.textProperty().addListener((observable, oldValue, newValue) -> {
                 valList[GridPane.getRowIndex(tf)][GridPane.getColumnIndex(tf)] = Integer.parseInt(newValue);
             });
         }

     }
 }