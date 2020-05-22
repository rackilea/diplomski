Vector mouseVec(mouseWorld.X, mouseWorld.Y);
Vector playerVec(playerWorld.X, playerWorld.Y);

//You want to find the angle the player must turn, so pretend the player pos it the origin
mouseVec -= playerVec;

//Create a vector that represents which way your player art is facing
Vector facingVec(1, 0);

mouseVec.Normalize();  //Make their length 1
facingVec.Normalize();

double dotProd = mouseVec.dot(facing);
double angBetween = acos(dotProd);