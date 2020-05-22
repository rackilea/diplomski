public Camera getCamera()
{

    for(int i = 0; i < Camera.getNumberOfCameras(); i++)
        return Camera.open(i);

    return null;
}