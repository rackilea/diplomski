slots.addListener(new ListChangeListener<Slot>() {

    @Override
    public void onChanged(ListChangeListener.Change<? extends Slot> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Slot slot : change.getAddedSublist) {
                    pane.getChildren().add(slot.getSlotContents());
                }
            } else if (change.wasRemoved()) {
                for (Slot slot : change.getRemoved()) {
                    pane.getChildren().remove(slot.getSlotContents());
                }
            }
        }
    }

});