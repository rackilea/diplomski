@Override
protected double computePrefHeight(double width) {
     ...
     if (expansionManager.layoutState == ExpansionManager.LayoutState.REQUEST_ANIMATION) {
        if(expansionManager.minHeight==0d){
            expansionManager.minHeight=getHeight();
        }
        expansionManager.fromHeight = getHeight();
        expansionManager.stepHeight = expansionManager.fromHeight;
        expansionManager.toHeight = expanded?super.computePrefHeight(width):
                                             expansionManager.minHeight;
        return expansionManager.fromHeight;
    }
}

@Override
protected double computePrefWidth(double height) {
    ...
    if (expansionManager.layoutState == ExpansionManager.LayoutState.REQUEST_ANIMATION) {
        if(expansionManager.minWidth==0d){
            expansionManager.minWidth=getWidth();
        }
        expansionManager.fromWidth = getWidth();
        expansionManager.stepWidth = expansionManager.fromWidth;
        expansionManager.toWidth = expanded?super.computePrefWidth(height):
                                            expansionManager.minWidth;
        return expansionManager.fromWidth;
    }
}