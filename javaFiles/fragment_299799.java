private void expand() {
    expansionManager.layoutState = ExpansionManager.LayoutState.REQUEST_ANIMATION;
    // this works...    
    listView = new ListView<>(listItem);
    this.getChildren().setAll(title,listView);
    expanded = true;
}