public int getAllTime(Route r){
    int res = 0;
    //Am assuming you will have logic to check the route is valid and all 
    //like ensuring that there are altleast two stops. so leaving out all that
    Stop initial = r.getStops().get(0);
    for (int i=1; i<r.getStops().size();i++){
        Stop dest=r.getStops().get(i);
        Point iniP = initial.getStation().getStationPosition();
        Point destP = dest.getStation().getStationPosition();
        res+=(int)getTimeDistance(iniP, destP);
        initial = dest
    }
    return res;  
}