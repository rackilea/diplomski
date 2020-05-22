private void enableAllRec(Container root, boolean defaultState, Set<Component> disableList, Set<Component> enableList) {
  if (root == null) return;
  for (Component c : root.getComponents()) {
    if (disableList != null && disableList.contains(c)) {
      c.setEnabled(false);
      disableList.remove(c);
    } else if (enableList != null && enableList.contains(c)) {
      c.setEnabled(true);
      enableList.remove(c);
    } else c.setEnabled(defaultState);
    if (c instanceof Container) enableAllRec((Container) c, defaultState, disableList, enableList);
  }
}