int[] sound = new int[4];
sound[0] = soundPool.load(this, R.raw.aww, 1);
sound[1] = soundPool.load(this, R.raw.arh, 1);
sound[2] = soundPool.load(this, R.raw.agg, 1);
sound[3] = soundPool.load(this, R.raw.uhh, 1);

Random random = new Random();

click = (Button) findViewById(R.id.bm);
click.setOnClickListener(new View.OnClickListener() {
    public void onClick(View click) {
        //choose one of four sound to play
        soundPool.play(sound[random.nextInt(4)], 1.0f, 1.0f, 0, 0, 1.0f);
    }
});