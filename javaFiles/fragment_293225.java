public double getLat(){
    double retVal = 0d;
    if (mLastLocation != null){
       retVal = mLastLocation.getLatitude();
    }
    return retVal;
}
public double getLon(){
    double retVal = 0d;
    if (mLastLocation != null){
       retVal = mLastLocation.getLongitude();
    }
    return retVal;
}