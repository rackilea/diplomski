public Node removeNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {

ObservableList<Node> childrens = gridPane.getChildren();
for(Node node : childrens) {
    if(node instanceof ImageView && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
        ImageView imageView=ImageView(node); // use what you want to remove
        gridPane.getChildren().remove(imageView);
        break;
    }
  } 
   }