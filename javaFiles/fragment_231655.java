import java.awt.Color;

public Class YourClass{

    Color fading = Color.white;

    public YourClass(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (fading.getRed() > 0) {
                    fading = new Color(fading.getRed() - 1, fading.getGreen() - 1, fading.getBlue() - 1);
                    //do other stuff here
                }
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 100);
    }
}