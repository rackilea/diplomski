MessageFormat statusFormat = new MessageFormat(bundle.getString("status.ready"));

status.textProperty().bind(
    Bindings.when(model.databaseProperty().isNull())
        .then(bundle.getString("status.loading"))
        .otherwise(
            Bindings.createStringBinding(
                () -> statusFormat.format(new Object[] { model.getDatabase().getSize() }),
                model.databaseProperty(),
                Bindings.selectInteger(model.databaseProperty(), "size")))
);