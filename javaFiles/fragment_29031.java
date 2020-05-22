public void rowProcessorSwitched(RowProcessor from, RowProcessor to) {
    if(from == inventoryLineProcessor){ // stopped processing inventory lines and will process some other row.
        List<InventoryLine> inventoryLines = inventoryLineProcessor.getBeans();

        //now assign a copy of this list to the last InventoryHeader you have
    }
}