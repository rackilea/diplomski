public int getHours() {
    return Math.abs((this.fTimeInMin - this.sTimeInMin) / 60);
}

public int getMinutes() {
    return Math.abs((this.fTimeInMin - this.sTimeInMin) % 60);
}