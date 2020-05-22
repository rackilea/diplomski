/**
 * Function to get Progress percentage
 * @param currentDuration
 * @param totalDuration
 * */
public int getProgressPercentage(long currentDuration, long totalDuration){
    Double percentage = (double) 0;

    long currentSeconds = (int) (currentDuration / 100);
    long totalSeconds = (int) (totalDuration / 100);

    // calculating percentage
    percentage =(((double)currentSeconds)/totalSeconds)*100;

    // return percentage
    return percentage.intValue();
}