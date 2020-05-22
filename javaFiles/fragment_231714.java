private void countNumbers() {
    final TextView numbers = (TextView) findViewById(R.id.textView2);


    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        public void run() {
            int i = 0;
            while (i++ < 500) {  
                try {
                    Thread.sleep(10);
                }    
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int j = i;
                handler.post(new Runnable(){
                    public void run() {
                        numbers.setText(Integer.toString(j));
                }
            });
            }
        }
    };
    new Thread(runnable).start();
}