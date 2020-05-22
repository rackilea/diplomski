if (dialogResult == JOptionPane.YES_OPTION) {
    for (CheckListItem items : mModel.items) {   // Iterating Items
        if (items.isSelected) {
            mModel.removeAt(items);     // REMOVE Item
        }
    }
}