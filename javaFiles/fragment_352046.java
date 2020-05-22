Table table = .... the table

int rows = table.getItemCount();
int columns = table.getColumnCount();

for (int rowIndex = 0; rowIndex < rows; ++rowIndex) {
   TableItem rowItem = table.getItem(rowIndex);

   for (int colIndex = 0; colIndex < columns; ++colIndex) {
       String colValue = rowItem.getText(colIndex);

       ....
   }
}