public void start()
{
    timerSchedule();            
}

public void timerSchedule()
{
    Timer timer = new Timer();

    timer.schedule(new TimerTask() {
        public void run() {
            /*Action codes here*/
        }
    }, /*Repeat Time here*/);
}