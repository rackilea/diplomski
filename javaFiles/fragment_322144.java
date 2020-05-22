public ClockThread(DigitalClock dc){
    if(dc == null){
       throw new IllegalArgumentException("Digital Clock cannot be Null. Initialize the Digital Clock Object first.");
    }
   //code reachable if no exception
    this.dc = dc;
    start();
}