if (location!=null 
    && ((location.getAccuracy() > newLocation.getAccuracy() + 100)
    && newLocation.distanceTo(location) > 1800)
{
    sendTask();
}