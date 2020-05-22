status.textProperty().bind(
    Bindings.when(model.databaseProperty().isNull())
        .then(bundle.getString("status.loading"))
        .otherwise(
            Bindings.selectInteger(model.databaseProperty(), "size").asString(
                bundle.getString("status.ready")))
);