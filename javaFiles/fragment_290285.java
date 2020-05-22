public void addSelected2List(){
    ShapeItem shape = new ShapeItem();
    shape.setShapeChoose((String)shapeChoice.getSelectedItem());
    shape.setColourChoose((String)colourChoice.getSelectedItem());
    shape.setSize((int)sizeChoice.getSelectedItem());
    list.add(shape);
}