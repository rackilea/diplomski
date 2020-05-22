Callback<TableColumn, TableCell> cellFactory =
         new Callback<TableColumn, TableCell>() {
             public TableCell call(TableColumn p) {
                return new EditingCell();
             }
         };