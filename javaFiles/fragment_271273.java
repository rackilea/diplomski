@Override
protected void layoutChildren() {
    int n=getChildren().size();
    double buttonSize = (2*radius-2*ext_gap-(n-1)*int_gap)/n;

    double x=ext_gap+buttonSize/2d, y;            
    for (Node node : getChildren()) {
        ((Button)node).setMinSize(buttonSize, buttonSize);
        ((Button)node).setPrefSize(buttonSize, buttonSize);
        ((Button)node).setMaxSize(buttonSize, buttonSize);

        node.setStyle("-fx-font-size: "+Math.round(buttonSize/3));
        node.setManaged(false);

        y=getHeight()/2d+Math.sqrt(radius*radius-Math.pow(x-radius,2d));

        layoutInArea(node, x-buttonSize/2d, y-buttonSize/2d, getWidth(), getHeight(), 0.0, HPos.LEFT, VPos.TOP);

        x+=buttonSize+int_gap;
    }

}