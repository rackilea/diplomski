mManButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            man = 1;
            linear = 0;
            auto = 0;
            cal = 0;
            test = 0;
            linear = 0;
            clearScreen();

            mManButton.setBackgroundResource(R.color.button_pressed);
            mStartButton.setBackgroundResource(R.color.button_default);
            mCalButton.setBackgroundResource(R.color.button_default);
            mTestButton.setBackgroundResource(R.color.button_default);
            mLinearButtton.setBackgroundResource(R.color.button_default);
            mAutoButton.setBackgroundResource(R.color.button_default);
            // Send a message using content of the edit text widget

            sendMessage("M");
            tv7.setText("Please wait....");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    time();
                }
            },5000);
        }

    });