public void onClick(View v) {
    // btnPlant.setEnabled(false);

        handler = new Handler();
        count = Integer.parseInt(etInput.getText().toString());

        Runnable r = new Runnable() {
            public void run() {
                count--;
                timer.setText(Integer.toString(count));
                handler.postDelayed(this, 1000);
            }
        };


        handler.postDelayed(r, 1000);
    }