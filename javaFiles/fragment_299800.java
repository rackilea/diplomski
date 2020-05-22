private void expand() {
    expansionManager.layoutState = ExpansionManager.LayoutState.REQUEST_ANIMATION;
    // this will avoid seeing the unresized listView
    listView.setOpacity(0);
    this.getChildren().setAll(title,listView);
    expanded = true;
}