Vector3 distance = new Vector3(from.x, from.y, from.z).sub(to.x, to.y, to.z);

if (distance.length() < DISTANCE_EPSILON)
{
    //exit - don't do any rotation
    //distance is too small for rotation to be numerically stable
}

//Don't actually need to call normalize for directionA - just doing it to indicate
//that this vector must be normalized.
final Vector3 directionA = new Vector3(0, 1, 0).normalize();
final Vector3 directionB = distance.clone().normalize();

float rotationAngle = (float)Math.acos(directionA.dot(directionB));

if (Math.abs(rotationAngle) < ANGLE_EPSILON)
{
    //exit - don't do any rotation
    //angle is too small for rotation to be numerically stable
}

final Vector3 rotationAxis = directionA.clone().cross(directionB).normalize();

//rotate object about rotationAxis by rotationAngle