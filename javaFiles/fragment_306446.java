imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
    Color color = image.getPixelReader().getColor(e.getX(),e.getY()));
    if(color.getAlpha() != 0)
    {
        //execute your code here
    }
});