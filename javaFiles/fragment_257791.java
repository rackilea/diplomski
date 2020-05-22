//I do not guarantee that this code compiles! I did not write it in an IDE nor did I compile it
float angleToRotX = 180f;
float angleToRotY = 90f;
float angleToRotZ = 0f;

// example vertex
Vector4f vertex = new Vector4f(0, 1, 0, 1);

// Rotate vertex's X coordinates by the desired degrees
Matrix4f rotationXMatrix = new Matrix4f();
rotationXMatrix.rotX(angleToRotX);

Matrix4f rotationYMatrix = new Matrix4f();
rotationYMatrix.rotY(angleToRotY);

Matrix4f rotationZMatrix = new Matrix4f();
rotationZMatrix.rotZ(angleToRotZ);

//now let's translate it by 1.5, 1, 1.5 in the X,Y,Z directions
Matrix4f translationMatrix = new Matrix4f();
translationMatrix.setTranslate(new Vector3f(1.5, 1, 1.5));

/*
Now we have our three rotational matrices. So we multiply them (transform them) to get a single matrix to transform all of the points in this model to the desired world coordinates

*/
Matrix4f rotationMatrix = new Matrix4f();
rotationMatrix.mul(rotationXMatrix);
rotationMatrix.mul(rotationYMatrix);
rotationMatrix.mul(rotationZMatrix);

Matrix4f worldMatrix = translationMatrix;
worldMatrix.mul(rotationMatrix);

//now worldMatrix, when applied to a vertex, will rotate it by X,Y,Z degrees about the origin of it's model space, and then translate it by the amount given in translationMatrix

worldMatrix.transform(vertex);

//now vertex should be (1.5, 0, 1.5, 1) with (x,y,z,1)