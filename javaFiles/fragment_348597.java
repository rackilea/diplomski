static final int RED = 0;
static final int GREEN = 1;
static final int YELLOW = 2;
static final int BLUE = 3;

mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mHandler.sendEmptyMessageDelayed(RED, 1000);
            }
        });

mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                switch (msg.what) {
                case RED:
                    mButton.setBackgroundColor(Color.rgb(255, 0, 0));
                    mHandler.sendEmptyMessageDelayed(GREEN, 1000);
                    break;
                case GREEN:
                    mButton.setBackgroundColor(Color.rgb(0, 255, 0));
                    mHandler.sendEmptyMessageDelayed(YELLOW, 1000);
                    break;
                case YELLOW:
                    mButton.setBackgroundColor(Color.rgb(255, 255, 0));
                    mHandler.sendEmptyMessageDelayed(BLUE, 1000);
                    break;
                case BLUE:
                    mButton.setBackgroundColor(Color.rgb(0, 0, 255));
                    mHandler.sendEmptyMessageDelayed(RED, 1000);
                    break;
                }

            }
        };