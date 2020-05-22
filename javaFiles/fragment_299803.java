@Override
protected void layoutChildren() {
        timeline.setOnFinished((done) -> {
            expansionManager.layoutState = ExpansionManager.LayoutState.IDLE;
            listView.setVisible(expanded);
            timeline = null;
        });
}

private void expand() {
    expansionManager.layoutState = ExpansionManager.LayoutState.REQUEST_ANIMATION;
    expanded = true;
    listView.setVisible(true);
    if(this.getChildren().size()==1){
        this.getChildren().add(listView);
    }
    requestLayout();
}

private void contract() {
    expansionManager.layoutState = ExpansionManager.LayoutState.REQUEST_ANIMATION;
    expanded = false;
    requestLayout();
}