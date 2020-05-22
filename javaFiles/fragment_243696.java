private void checkTimeDiff(){
    iterations++;

    long time = SystemClock.elapsedRealtime();
    if (record_state == 1)
    {
        start_time = SystemClock.elapsedRealtime();
        record_state = 0;
    }

    long diff = time - start_time;
    Log.e("My Timer", "Time difference = " + diff + " number of iterations = " + iterations);

    if (diff >= 4000)
    {
        record_start = 1;
        Toast.makeText(MainActivity.this, Long.toString(time) + "\n" + Long.toString(start_time), Toast.LENGTH_SHORT).show();
    }
}