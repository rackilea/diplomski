private Runnable doStuff= new Runnable() {
//Notice doStuff is a member of the class.
            public void run() {
               //do awesome stuff here.
             mp.start();
            }
        };
//...
 toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
            if (isChecked) {
             final Handler mHandler= new Handler();
                mHandler.postDelayed(doStuff,1000*30);//30 second delay.
            } else {
                mp.stop();
            }
        }