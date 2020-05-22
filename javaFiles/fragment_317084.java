long now = System.currentTimeMillis();
for(int i=0; i<NUM_STONES; i++){
    if(now < changeTimes[i]){ // if the time has come
        if(visible[i]) changeTimes[i] = now + r.nextInt(5000); // every stone will be invisible up to five seconds
        else changeTimes[i] = now + r.nextInt(10000); // every stone will be visible again up to 10 seconds
        visible[i] = !visible[i]; // switch the visibility state
   }
}