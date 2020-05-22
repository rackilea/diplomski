clockText = findViewById(R.id.timer);    
final Button startButton = findViewById(R.id.timerBtn);
    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if(startButton.getText().toString().toLowerCase().equals("resume")) {
                startTimer(milliLeft);
                clock.start();
                startButton.setText("resume");
            }
            else if(startButton.getText().toString().toLowerCase().equals("pause")){
                clock.cancel();
                clockText.setText(formatTime);
                startButton.setText("resume");
            }
            else if(startButton.getText().toString().toLowerCase().equals("start")){
                startTimer(30000);
                startButton.setText("pause");
                clock.start();
            }

        }
    });