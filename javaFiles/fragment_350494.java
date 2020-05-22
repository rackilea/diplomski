public int plusMinutes (int time, int minutes) {
    int auxMinutes = time % 60;
    auxMinutes += minutes;
    time += 100 * (seconds / 60);
    time = 100 * (time / 100); // set the last 2 digits to 0
    time += auxMinutes % 60;

    return time;
}