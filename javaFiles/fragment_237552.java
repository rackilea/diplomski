//ship heading (already calculated)
Vector3f heading /* = ... */;
heading.normalize();

//direction of enemy ship relative to ours
Vector3d direction = new Vector3f(enemy.x - ship.x, enemy.y - ship.y, enemy.z - ship.z);
direction.normalize();

//angle between vectors
float angle = heading.angle(direction);