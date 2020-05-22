final Handler h = new Handler() {

            @Override
            public void handleMessage(@NonNull Message msg) {

               Translations x = dict.get(i-1);
                        switch (j) {
                            case 1: {
                                Log.d(TAG, "First word translated");
                                englishTrans1.setText(x.getEnglishWord());
                                polishTrans1.setText(x.getPolishWord());
                                break;
                            }
                            case 2: {
                                Log.d(TAG, "Second word translated");
                                englishTrans2.setText(x.getEnglishWord());
                                polishTrans2.setText(x.getPolishWord());
                                break;
                            }
                            case 3: {
                                Log.d(TAG, "Third word translated");
                                englishTrans3.setText(x.getEnglishWord());
                                polishTrans3.setText(x.getPolishWord());
                                break;
                            }

                        }

                }


            };


        Runnable r = new Runnable() {
            @Override
            public void run() {

                for(i = 0;i<dict.size();i++) {

                    try {
                        Thread.sleep(2000);

                    }catch (InterruptedException e){
                    }

                    if (j < 3) {
                        j++;
                    } else {
                        j = 1;
                    }
                    h.sendEmptyMessage(0);
                }


            }
        };

        Thread t = new Thread(r);
        t.start();



    }
}