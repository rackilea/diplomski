else {            
    //check for this condition, otherwise for i=0 you will have an exception 
    if (i>0) {
        Double lati=c1.getDouble(2);
        Double longi=c1.getDouble(3);
        myTargetLocation.setLatitude(lati);
        myTargetLocation.setLongitude(longi);
        dis[i]=(int) mySourceLocation.distanceTo(myTargetLocation);
        disbetween[i]=dis[i]-dis[i-1];
        distancelist.add(disbetween[i].toString());
        Toast.makeText(getApplicationContext(),longi+"  "+lati+" "+disbetween[i], 1).show();
    }
    else {
        //handle the situation if i < 0
    }
}