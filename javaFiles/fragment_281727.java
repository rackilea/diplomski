addresses = geoCoder.getFromLocation(mLatitude, mLongitude, 10);
if (addresses != null) {
    int i=1;
    for(Address addObj:addresses)
    {
        ...
    }
}