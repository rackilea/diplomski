private long startTime;

private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

public void OnCreate(Bundle b) {

    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {

           startTime = System.currentTimeMillis();

       }
    });

    stop = (Button) findViewById(R.id.stop);
    stop.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {

        long elaspedTime = System.currentTimeMillis() - startTIme;

    try {
        BufferedWriter out = new BufferedWriter(new FileWriter("/sdcard/timer.txt", true));
        out.write("Elapsed time:" + dateFormat.format(new Date(elapsedTime)));
        out.write("\r\n");
        out.close();
    } catch (Exception e) {
    }

    }
  });