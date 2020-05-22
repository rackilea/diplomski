@Override
public void clearAndSelect(int row) {
    clearAndSelect(row, null);
}

@Override
public void selectRange(int start, int end) {
    IntStream.range(start, end).forEach(selection::add);
    updateSelection();
}

@Override
public boolean isSelected(int row) {
    return isSelected(row, null);
}