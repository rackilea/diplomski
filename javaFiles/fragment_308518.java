String [] segments = ipAddress.split("\\.");
if(!(segments.length == 4))
{
    return false;
}
return isAValidOctet(segments);