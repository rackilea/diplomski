final PseudoClass toggleRed = PseudoClass.getPseudoClass("toggleRed");

ObjectProperty<LocalDate> currentDate = ...;

treeTableView.setRowFactory(ttv -> new JFXTreeTableRow<Job>() {

    private final InvalidationListener listener = o -> {
        Job item = getItem();
        pseudoClassStateChanged(toggleRed, item != null && item.getStartDate().isAfter(currentDate.get()));
    };
    private final WeakInvalidationListener l = new WeakInvalidationListener(listener);

    {
        // listen to changes of the currentDate property
        currentDate.addListener(l);
    }

    @Override
    protected void updateItem(Job item, boolean empty) {
        // stop listening to property of old object
        Job oldItem = getItem();
        if (oldItem != null) {
            oldItem.startDateProperty().removeListener(l);
        }

        super.updateItem(item, empty);

        // listen to property of new object
        if (item != null) {
            item.startDateProperty().addListener(l);
        }

        // update pseudoclass
        listener.invalidated(null);
    }
});