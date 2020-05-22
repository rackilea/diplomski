class StopWatch {
    int minutes;
    int seconds;
    int milliseconds;

    public StopWatch(String startTime) {
        String[] timeArray = startTime.split(":");

        if (timeArray.length == 3) {
            this.minutes = Integer.parseInt(timeArray[0]);
            this.seconds = Integer.parseInt(timeArray[1]);
            this.milliseconds = Integer.parseInt(timeArray[2]);
        } else if (timeArray.length == 2) {
            this.minutes = 0;
            this.seconds = Integer.parseInt(timeArray[0]);
            this.milliseconds = Integer.parseInt(timeArray[1]);
        } else if (timeArray.length == 1) {
            this.minutes = 0;
            this.seconds = 0;
            this.milliseconds = Integer.parseInt(timeArray[0]);
        } else {
            this.minutes = 0;
            this.seconds = 0;
            this.milliseconds = 0;
        }
    }
}