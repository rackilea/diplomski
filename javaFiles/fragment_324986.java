if(channel.equals(EIsolateChannel.ISOLATE_RED_CHANNEL))
{
    newPixel = newPixel | iRed<<16; 
    //Can also write newPixel=iRed , since newPixel is always 0 before this
}

if(channel.equals(EIsolateChannel.ISOLATE_GREEN_CHANNEL))
{
    newPixel = newPixel | iGreen<<8;
}

if(channel.equals(EIsolateChannel.ISOLATE_BLUE_CHANNEL))
{
    newPixel = newPixel | iBlue;
}