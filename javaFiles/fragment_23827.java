else if (i == 7) {
    long difference = SystemClock.elapsedRealtime()  - startTime;

    Intent intent1 = new Intent(Game.this, MainScreen.class);
    intent1.putExtra("time",difference);

    finish();
}