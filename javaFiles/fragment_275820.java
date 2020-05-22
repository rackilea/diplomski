private void MeasureExecutionTime(Runnable r) {
    r.run();
}

...


MeasureExecutionTime(new Runnable() { public void run() { m(); } });