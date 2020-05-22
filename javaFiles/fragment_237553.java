//calculate angle to rotate
float deltaRotation = rotationVelocity * deltaTime;

//calcuate percent of rotation 
float percent = Math.min(deltaRotation / angle, 1.0f);

//create interpolated vector representing the new forward direction
Vector3f inter = new Vector3f(heading.x + percent * (direction.x - heading.x), heading.y + percent * (direction.y - heading.y), heading.z + percent * (direction.z - heading.z));
inter.normalize();