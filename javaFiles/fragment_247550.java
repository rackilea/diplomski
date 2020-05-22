public TextArea getNodeByRowColumnIndex( final int row, final int column, GridPane gridPane) 
{

   ObservableList<Node> childrens = gridPane.getChildren();
   TextArea result = (TextArea) childrens.get((row*3)+column);

   return result;
}