private void removeDownloads(List<? extends Download> downloads) {
    // remove treeitems from the treeview that hold these downloads
    List<TreeItem<Download>> treeItemsToRemove = treeDownloads.getRoot().getChildren().stream()
            .filter(treeItem -> downloads.contains(treeItem.getValue()))
            .collect(Collectors.toList());
    treeDownloads.getRoot().getChildren().removeAll(treeItemsToRemove);
}