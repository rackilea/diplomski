btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Trying to switch on 3G!",Toast.LENGTH_SHORT).show();

                (new Thread(new Runnable() {
                    @Override
                    public void run() {

                        setMobileDataEnabled(MainActivity.this,true);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Switched ON 3G!", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                })).start();
            }
        });