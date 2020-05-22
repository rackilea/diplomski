if (dialogResult == JOptionPane.YES_OPTION) {
    // First collect all the selected CheckListItem
    List<CheckListItem> removed = new ArrayList<CheckListItem>();
    for (CheckListItem item : mModel.items) {
        if (item.isSelected) {
            removed.add(item);
        }
    }

    // Finally remove the selected CheckListItem
    for (CheckListItem item : removed) {
        mModel.removeAt(item);
    }
}