public void click1(View v){
                Button b = (Button)findViewById(R.id.button2);
                b.setText("TEXT 1");
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        b.setText("TEXT 2");    
                    }
                }, 500;)
                //b.forceLayout();
            }