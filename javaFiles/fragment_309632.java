// Create vectors
Vector3f directionVector = new Vector3f(dx, dy, dz);
Vector3f axisVector = new Vector3f(ax, ay, az);
Vector3f constantBaseVector = new Vector3f(1, 0, 0);

//Calculate angle
float angle = constantBaseVector.angle(directionVector);

//create AxisAngle4f
AxisAngle4f axisAngle = new AxisAngle4f(axisVector, angle);