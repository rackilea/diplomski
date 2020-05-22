long pastTime = 0;
public boolean isReadyToDeploy(long delta) {
    if(pastTime < 3 * 1000) { //multiply by 1000 to get milliseconds
        pastTime += delta;
        return false;
    }else{
        pastTime = 0;
        return true;
    }
}