private TrafficLight<String> trafficLight = new TrafficLight<>();

public void methodA() {//ignored try catch finally
    trafficLight.acquire("A");
    //do stuff
    trafficLight.release();
}

public void methodB() {
    trafficLight.acquire("B");
    //do stuff
    trafficLight.release();
}