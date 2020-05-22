// first create a method like this
// this static method to return a component from Table at specific row and column
public static Node getComponent (int row, int column, GridPane table) {
    for (Node component : table.getChildren()) { // loop through every node in the table
        if(GridPane.getRowIndex(component) == row && 
                        GridPane.getColumnIndex(component) == column) {
            return component;
        }
    }

    return null;
}

// Then use the method like this
// The textfield always at Column 0, check box column 1 and Date picker 2
// and the GridPane is in a StackPane(container) at index 0
// Note that you may NEED to add a button and wrap the following code with its Action Listener (i.e. button.setOnAction())
if(containerB.getChildren().size()>0){ // that means it contains a table    
    GridPane table = (GridPane) containerB.getChildren().get(0);
    for(int i=0 ; i<comboBox.getValue(); i++){
        String Text = ((TextField)getComponent (i, 0, table)).getText();
        boolean selected = ((CheckBox)getComponent (i, 1, table)).isSelected();
        LocalDate date = ((DatePicker)getComponent (i, 2, table)).getValue();

        System.out.println(Text + " " + selected + " " + date);
        System.out.println("Next Row");
    }

}