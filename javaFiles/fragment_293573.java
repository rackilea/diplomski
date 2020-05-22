for (byte b:byteArray)
{
    int ib = b & 0xFF;         // This scales up to integer so you have values 0-255
    if(ib >=0x00 && ib<=0x1F)
    {
        //do something
    }
    else if(ib>=0x20 && ib <=0xFE)
    {   
         //do something
    }
    else if(ib == 0xFF)
    {
        //do something
    }
    else
    {
        // log a bug! This should never happen!
    }
}