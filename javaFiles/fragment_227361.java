private static final double SIDE = 60;
private Path path;

private void createPath() {
    path.getElements().clear();
    path.getElements().add(new MoveTo(0d, 0d));

    // top
    path.getElements().add(new LineTo(SIDE / 3d ,0));
    switch (top) {
        case GREATER: path.getElements().add(new MoveTo(2d * SIDE / 3d, 0d)); break;
        case EQUAL: path.getElements().add(new LineTo(2d * SIDE / 3d, 0d)); break;
        case LOWER: path.getElements().add(new LineTo(SIDE / 2d, SIDE / 5d)); 
                    path.getElements().add(new LineTo(2d * SIDE / 3d, 0d)); 
                    break;
    }
    path.getElements().add(new LineTo(SIDE, 0d));

    // right
    path.getElements().add(new LineTo(SIDE, SIDE / 3d));
    switch (right) {
        case GREATER: path.getElements().add(new MoveTo(SIDE, 2d * SIDE / 3d)); break;
        case EQUAL: path.getElements().add(new LineTo(SIDE, 2d * SIDE / 3d)); break;
        case LOWER: path.getElements().add(new LineTo(SIDE - SIDE / 5d, SIDE / 2d)); 
                    path.getElements().add(new LineTo(SIDE, 2d * SIDE / 3d)); 
                    break;
    }
    path.getElements().add(new LineTo(SIDE, SIDE));

    // bottom
    path.getElements().add(new LineTo(2d * SIDE / 3d, SIDE));
    switch (bottom) {
        case GREATER: path.getElements().add(new MoveTo(SIDE / 3d, SIDE)); break;
        case EQUAL: path.getElements().add(new LineTo(SIDE / 3d, SIDE)); break;
        case LOWER: path.getElements().add(new LineTo(SIDE / 2d, SIDE - SIDE / 5d)); 
                    path.getElements().add(new LineTo(SIDE / 3d, SIDE)); 
                    break;
    }
    path.getElements().add(new LineTo(0d, SIDE));

    // left
    path.getElements().add(new LineTo(0d, 2d * SIDE / 3d));
    switch (left) {
        case GREATER: path.getElements().add(new MoveTo(0d, SIDE / 3d)); break;
        case EQUAL: path.getElements().add(new LineTo(0d, SIDE / 3d)); break;
        case LOWER: path.getElements().add(new LineTo(SIDE / 5d, SIDE / 2d)); 
                    path.getElements().add(new LineTo(0d, SIDE / 3d)); 
                    break;
    }
    path.getElements().add(new LineTo(0d, 0d));
}