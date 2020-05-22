//Create a Rotate Object
Rotate rotate = new Rotate();
rotate.setPivotX(node.getX()); //Pivot X Top-Left corner
rotate.setPivotY(node.getY()); //Pivot Y
rotate.setAngle(angle); //Angle degrees

//Add the transform to the node
node.getTransforms().add(rotate);