class CustomTreeCell extends TreeCell<CustomObject>{

    private final ChangeListener<Boolean> listener = (o, ov, nv) -> pseudoClassStateChanged(customClass, nv);

    PseudoClass customClass = PseudoClass.getPseudoClass("custom");

    @Override
    protected void updateItem(CustomObject co, boolean empty) {
        // remove listener from old item
        CustomObject oldItem = getItem();
        if (oldItem != null) {
            oldItem.state.removeListener(listener);
        }

        super.updateItem(co, empty);

      if (empty || co == null) {
        setText(null);
        setGraphic(null);
        pseudoClassStateChanged(customClass, false);

      } else {
        setText(co.label);
        setGraphic(null);

        /* define background color of cell according to state */
        pseudoClassStateChanged(customClass, co.state.getValue());
        co.state.addListener(listener);

        ...