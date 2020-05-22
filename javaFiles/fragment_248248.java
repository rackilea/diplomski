private int run = 0;
        private Handler handler=new Handler();
        private Runnable runnable=new Runnable() {
            @Override
            public void run() {
                xMethod();
// Put your code here, what you want to do 5 times
            }
        };