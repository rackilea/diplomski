private long lastTrueTime;
private boolean timedBoolean() {
        long now= System.currentTimeMillis();
        if(/*condition to set boolean true*/){ 
            lastTrueTime=now;
            return true;
        }

        if (lastTrueTime+3000<now)
            return false;

        return true;
}