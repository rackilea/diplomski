public void increment() {    
    seconds ++;
    if (seconds >= 60)
    {
       seconds = 0;
       minutes ++;
    }
    if(minutes >= 60)
    {
       hours++;
       minutes = 0;
    }
    if(hours >= 24)
    {
       hours = 0;
    }
}