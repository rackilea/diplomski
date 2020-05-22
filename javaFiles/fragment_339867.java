public void mouseDragged(MouseEvent event) {
    //if (event.isMetaDown()) {
        //newCircle = new Circle(getCircleSize(), event.getPoint(),
        //        this.getBackground());
        newCircle = new Circle(getCircleSize(), event.getPoint(),
                getCircleColor());
        circleArrayList.add(newCircle);
        repaint();

    //}
}