if(newLocation != null)
{
    if(location != null)
    {
        if(location.getAccuracy() > newLocation.getAccuracy() + 100)
            sendTask();
        else
            if(newLocation.distanceTo(location) > 1800)
                sendTask();
    }
    else
        sendTask();
}