double coolDownInMillis = 1200;
double lastTime = 0;

public void move() {
    double now = System.currentTimeMillis();
    if(lastTime - now > coolDownInMillis  && pressingTheRightKey()){
        //do what you want
        lastTime = System.currentTimeMillis();
    }
}