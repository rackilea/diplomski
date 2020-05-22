private Calendar startTime;
private long duration;
private long startNanos;   //Nano-second precision, could be less precise
...
this.startTime = Calendar.getInstance();
this.duration = 0;
this.startNanos = System.nanoTime();

public void setEndTime() {
        this.duration = System.nanoTime() - this.startNanos;
}

public Calendar getStartTime() {
        return this.startTime;
}

public long getDuration() {
        return this.duration;
}