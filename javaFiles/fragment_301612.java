private final double PADDING = 9d;
private final double BORDER  = 1d;

private void setTooltipWidth(Tooltip tooltip){
    if(tooltip==null || 
        tooltip.getScene()==null || 
        tooltip.getScene().getRoot()==null){
        return;
    }
    Text text=(Text)tooltip.getScene().getRoot().lookup(".text");
    if(text==null || text.getLayoutBounds().getWidth()==0){
        return;
    }
    double width=2d*(PADDING+BORDER)+Math.ceil(text.getLayoutBounds().getWidth());
    tooltip.setPrefWidth(width);
}