private int count = 0;
    Button btn;
    private final Handler mHandler = new Handler();
    private Runnable mTimer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        mTimer1 = new Runnable() {

            @Override
            public void run() {
                count++;
                // TODO Auto-generated method stub
                mHandler.postDelayed(this, 500);
                if (count == 1) {
                    mHandler.removeCallbacks(mTimer1);
                    // put your code here:
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                   i = manager.getLaunchIntentForPackage("com.technorapper.technorappermapp");
                if (i == null)
                    throw new PackageManager.NameNotFoundException();
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }

                }
            }
        };
        btn.setOnTouchListener(new OnTouchListener() {

            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    initialX = (int) btn.getX();
                    initialY = (int) btn.getY();
                    initialTouchX = event.getRawX();
                    initialTouchY = event.getRawY();
                    mHandler.postDelayed(mTimer1, 0);
                    return true;
                case MotionEvent.ACTION_UP:
                    count = 0;
                    return true;
                case MotionEvent.ACTION_MOVE:
                    runOnUiThread(new Runnable() {
                        public void run() {
                            btn.setX(initialX
                                    + (int) (event.getRawX() - initialTouchX));
                            btn.setY(initialY
                                    + (int) (event.getRawY() - initialTouchY));
                        }
                    });

                    return true;
                }
                return false;
            }
        });