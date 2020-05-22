private boolean hasCollided( ?[] poly, ? bounds )
{
    for ( ? polyX : poly )
    {
        if( polyX.intersects( bounds )  return true;
    }
    return false;        
}