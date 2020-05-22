tv2_r7 = (TextView) this.findViewById(R.id.textView2_r7);

    final Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask()
    {
        int i = 10;

        public void run()
        {
            runOnUIThread(new Runnable()
            {

                @Override
                public void run()
                {
                    tv2_r7.setText(String.valueOf(i));

                }
            });

            i--;
            if (i < 0)
                timer.cancel();
        }
    }, 0, 1000);
}