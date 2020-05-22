private static class MyList extends JList {

    public void setSelectedIndices(Set<Integer> indices) {
        ListSelectionModel model = getSelectionModel();
        model.clearSelection();
        for (Integer index : indices) {
            model.addSelectionInterval(index, index);
        }
    }