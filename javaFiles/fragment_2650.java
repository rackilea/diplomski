//Initialize these up top
private float deltaX1 = 0;
private float deltaY1 = 0;
private float deltaZ1 = 0; 

@Override
public void onSensorChanged(final SensorEvent event) {

            deltaX1 = (float) ((event.values[0])/9.81);
            deltaY1 = (float) ((event.values[1])/9.81);
            deltaZ1 = (float) ((event.values[2])/9.81);

}


timer.scheduleAtFixedRate(new TimerTask() {

    @Override
    public void run() {

        listx.add(String.valueOf(deltaX1));
        listy.add(String.valueOf(deltaY1));
        listz.add(String.valueOf(deltaZ1));

    }, 0, 250);//put here time 1000 milliseconds=1 second\
}