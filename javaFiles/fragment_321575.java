TableColumn<MovimientoDTO, Integer> columnCantidad = new TableColumn<>("Cantidad");
    columnCantidad.setCellValueFactory((param) -> param.getValue().cantidadPropertyProperty().asObject());
    columnCantidad.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
    columnCantidad.setResizable(false);
    columnCantidad.setEditable(true);
    columnCantidad.setCellFactory(new Callback<TableColumn<MovimientoDTO, Integer>, TableCell<MovimientoDTO, Integer>>() {

        @Override
        public TableCell<MovimientoDTO, Integer> call(TableColumn<MovimientoDTO, Integer> param) {
            TextFieldTableCell<MovimientoDTO, Integer> myEditableTableCell = new TextFieldTableCell<MovimientoDTO, Integer>(new IntegerStringConverter()) {

                @Override
                public void commitEdit(Integer val) {
                    int index = this.getTableRow().getIndex();
                    MovimientoDTO mov = table.getItems().get(index);
                    mov.setCantidadProperty(val);
                    //mov.setTotal(val * mov.getPrecioVenta());
                    super.commitEdit(val);
                }
            };

            return myEditableTableCell;
        }
    });

    TableColumn<MovimientoDTO, Double> columnTotal = new TableColumn<>("Total");
    columnTotal.setCellValueFactory((param) -> {
        param.getValue().totalPropertyProperty().bind(param.getValue().cantidadPropertyProperty().
                multiply(param.getValue().getPrecioVenta()));
        return param.getValue().totalPropertyProperty().asObject();
    });

    columnTotal.prefWidthProperty().bind(table.widthProperty().multiply(0.30));
    columnTotal.setResizable(false);
    columnTotal.setCellFactory((d) -> {
        TableCell<MovimientoDTO, Double> cell = new TableCell<MovimientoDTO, Double>() {

            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                setText(String.valueOf(item));
            }

        };

        return cell;
    });