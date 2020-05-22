class RegrowCornAnimate extends TimerTask {

    private final int serial;


    RegrowCornAnimate ( int serial )
    {
      this.serial = serial;
    }

    public void run() {
      //Do stuff
    }
}

...
int i = 0;
while (i < array.size){
    Timer timer = new Timer();
    timer.schedule(new RegrowCornAnimate( i ), 0, 1000);
    i++;
}
...