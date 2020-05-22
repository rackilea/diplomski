Control[] children = viewer.getTable().getChildren();
for(Control element : children) {
    if(element instanceof Button) {
        element.dispose();
    }
}