// disable cell
        cell.disableProperty().bind(wrap.disabledProperty());

    // or "hide" cell with blank gap
        // - with new property in Wrap
        cell.opacityProperty().bind(wrap.opacityProperty());
        // - with a Binding
        cell.opacityProperty().bind(
            Bindings.createDoubleBinding(()->wrap.disabledProperty().get()?0d:1d,
                    wrap.disabledProperty()));