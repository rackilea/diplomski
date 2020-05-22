public void display(GLAutoDrawable drawable) {
    updateCube();
    drawCube(...);
}

private void updateCube() {
    if(Shp_Cube.cubeAngle < Shp_Cube.cubeAngle + 90f) {
        Shp_Cube.cubeAngle += Shp_Cube.cubeSpeed;
    } else {
        Shp_Cube.cubeSpeed = 0; // stop rotattion after angle reched
    }
}

public void mouseClicked(MouseEvent m) {
    switch(m.getButton()) {
    case 1:
        Shp_Cube.cubeSpeed = INITIAL_SPEED; // this should only start rotation by setting positive speed
        break;
    }
}