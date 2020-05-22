public void setText(final String s)
    {
    TextView tv= (TextView)HomeActivity.tf.getView().findViewById(R.id.textViewFragment);
    final int[] i = new int[1];
    i[0] = 0;
    final int length = s.length();
    final Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            char c= s.charAt(i[0]);
            Log.d("Strange",""+c);
            tv.append(String.valueOf(c));
            i[0]++;
        }
    };

    final Timer timer = new Timer();
    TimerTask taskEverySplitSecond = new TimerTask() {
        @Override
        public void run() {
            handler.sendEmptyMessage(0);
            if (i[0] == length - 1) {
                timer.cancel();
            }
        }
    };
    timer.schedule(taskEverySplitSecond, 1, 500);
}