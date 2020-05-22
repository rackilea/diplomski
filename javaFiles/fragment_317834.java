private void inverseVisibility(JToggleButton expand, JPanel target) {
    if (expand.isSelected()) {
        target.setVisible(true);
    } else {
        target.setVisible(false);
    }
}