public void someMethod(Class<? extends Shape> type, File shapeFile) {
    ThirdPartyClass foo = new ThirdPartyClass();

    @SuppressWarnings("unchecked")
    Class<? extends Shape[]> arrayType = 
        (Class<? extends Shape[]>) Array.newInstance(type, 0).getClass();
    assert Shape[].class.isAssignableFrom(arrayType);

    Shape[] shapes = foo.someMajicMethod(arrayType, shapeFile);

    for (Shape shape: shapes)
        shape.draw();
}