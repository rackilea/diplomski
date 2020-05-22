int touchX, touchY;
int centerObjX, centerObjY;
int rayon;

int distX = centerObjX - touchX; // the sens don't matter
int distY = centerObjY - touchY; 
if (distX*distX + distY*distY<rayon*rayon) // squared distance
{
    // touch in the circle
}