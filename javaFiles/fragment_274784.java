static void moveUp(TreeItem item) {
    if (item.getParent() instanceof TreeItem) {
        TreeItem parent = item.getParent();
        List<TreeItem> list = new ArrayList<TreeItem>();
        Object prev = null;
        for (Object child : parent.getChildren()) {
            if (child == item) {
                list.add((TreeItem)child);
            } else {
                if (prev != null) list.add((TreeItem)prev);
                prev = child;
            }
        }
        if (prev != null) list.add((TreeItem)prev);
        parent.getChildren().clear();
        parent.getChildren().addAll(list);
    }
}