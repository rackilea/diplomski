btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Trying to switch off 3G!",Toast.LENGTH_SHORT).show();

                (new Thread(new Runnable() {
                    @Override
                    public void run() {

                        setMobileDataEnabled(MainActivity.this,false);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Switched OFF 3G!", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                })).start();



            }
        });