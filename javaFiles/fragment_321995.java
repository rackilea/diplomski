public class RaceSession{
    private int lap;
    private String maxLapTimeMs;
    private boolean quickRace;
    public int getLap() {
        return lap;
    }
    public void setLap(int lap) {
        this.lap = lap;
    }
    public String getMaxLapTimeMs() {
        return maxLapTimeMs;
    }
    public void setMaxLapTimeMs(String maxLapTimeMs) {
        this.maxLapTimeMs = maxLapTimeMs;
    }
    public boolean isQuickRace() {
        return quickRace;
    }
    public void setQuickRace(boolean quickRace) {
        this.quickRace = quickRace;
    }
}