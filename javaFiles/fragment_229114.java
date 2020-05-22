colDiferencia.setCellValueFactory((cellData) -> {
    cellData.getValue().DiferenciaExistenciaProperty()
            .bind(cellData.getValue().ProductosExistenciaActual().subtract(
                    Double.valueOf(String.valueOf(cellData.getValue().ProductosExistenciaInicialProperty()))));
    return cellData.getValue().DiferenciaExistenciaProperty().asObject();
});

colExistenciaF.setCellFactory((d) -> {
    TableCell<Productos, Double> cell = new TableCell<Productos, Double>() {
        @Override
        protected void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            setText(String.valueOf(item));
        }

    };
    return cell;
});