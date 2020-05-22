private int getContentsWidth(){
    int width = 0;
    for(Node node : getChildrenUnmodifiable()){
         width += node.boundsInLocalProperty().get().getWidth();
    }
    return width;
}