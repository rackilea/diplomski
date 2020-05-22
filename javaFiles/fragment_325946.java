PseudoClass highPriority = PseudoClass.getPseudoClass("high-priority");
PseudoClass lowPriority = PseudoClass.getPseudoClass("low-priority");
table.setRowFactory(tv -> new TableRow<Job>() {
    @Override
    public void updateItem(Job item, boolean empty) {
        super.updateItem(item, empty);
        pseudoClassStateChanged(highPriority, item != null && item.getPrioritySetting() == 3);
        pseudoClassStateChanged(lowPriority, item != null && item.getPrioritySetting() == 1);
    }
});