TextView textView;

textView = (TextView) findViewById(R.id.textView);

testBlink();

    private void testBlink() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (textView.getText().toString().equals("")) {
                            textView.setText("Nilesh");
                        } else {
                            textView.setText("");
                        }
                        testBlink();
                    }
                });
            }
        }).start();
    }