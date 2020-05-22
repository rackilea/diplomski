public static <S, T> TableColumn<S, T> createColumn(final int minWidth,
                                                    final Callback<TableColumn<S, T>, TableCell<S, T>> cellFactory) {
  TableColumn<S, T> tableColumn = new TableColumn<>();

  tableColumn.setMinWidth(minWidth);
  tableColumn.setCellFactory(cellFactory);

  return tableColumn;
}