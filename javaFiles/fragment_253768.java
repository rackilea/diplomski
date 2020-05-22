public GridPane CreateField(){
    GridPane grid = new GridPane();
    grid.setVgap(2);
    grid.setHgap(2);
    EventHandler<MouseEvent> handler = evt -> {
        Node source = (Node) evt.getSource();
        int row = GridPane.getRowIndex(source);
        int column = GridPane.getColumnIndex(source);
        ...
    };
    for(int i = 0; i < this.columns; i++){
        for(int j = 0; j < this.rows; j++){
            Rectangle rect = new Rectangle(this.height*j, this.width*i, this.height, this.width);
            this.array[j][i] = 0;
            this.field[i][j] = rect;
            rect.setStroke(Color.BLACK);
            rect.setFill(Color.LIGHTGRAY);
            rect.setOnMouseClicked(handler);
            grid.add(rect, j, i);
        }
    } 
    return grid;
}