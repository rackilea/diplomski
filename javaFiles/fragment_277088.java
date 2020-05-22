public void execute() {
start();
timer_.scheduleRepeating(100);
}

public void start() {
    timer_ = new Timer() {
       public void run() {
        update();
        }
    };
}


public void update() {
    if (time > neededTime) {
        timer_.cancel();
    }else {
      if(!animator) {  //needs some optimization
        animator = new Animator( ....
      }
    }   
 }