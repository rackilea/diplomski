public void fillBoardEvent(ActionEvent event) {

    int numRows = 50 ;
    int numColumns = 50 ;

    for (int i = 0 ; i < numRows; i++) {
        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);
        gridBoard.getRowConstraints().add(row);
    }

    for (int j = 0 ; j < numColumns; j++) {
        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);
        gridBoard.getColumnConstraints().add(col);            
    }

    for(int i = 0; i < numRows; i++) {
        for(int j = 0; j < numColumns; j++) {
            InitiateCells n;

            // code as before...
        }
    }
}