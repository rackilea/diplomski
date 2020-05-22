public JComponent addTo(JComponent parent, JComponent... children) {
    if (children != null && children.length > 0) {
        for (JComponent child : children) {
            parent.add(child);
        }
    }
    return parent;
}