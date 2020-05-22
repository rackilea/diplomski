private class ShapeRepresentation extends Cylinder {

    Val<Shape> shape;

    private ShapeRepresentation() {

        super(100, 100);

        shape = Val.wrap(cell.shapeProperty());

        Var<Number> sizeVar = shape.selectVar(Shape::sizeProperty);

        // THIS WILL WORK

        materialProperty().bind(shape
            .map(s -> new PhongMaterial(Color.RED))
            .orElseConst(new PhongMaterial(Color.TRANSPARENT)));

        // SO WILL THIS

        materialProperty().bind(sizeVar
                .map(n -> {
                    if (n.intValue() == 1) return new PhongMaterial(Color.RED) ;
                    if (n.intValue() == 2) return new PhongMaterial(Color.BLUE) ;
                    return new PhongMaterial(Color.WHITE);
                })
                .orElseConst(new PhongMaterial(Color.TRANSPARENT)));

    }
}