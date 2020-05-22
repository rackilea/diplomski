@Override
    public void onClick(View v) {
        runOnUiThread(new Thread(new Runnable() {
            @Override
            public void run() {
                // Reset all buttons
                btnA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                btnB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                btnC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                btnD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                .
                .
                .
                btnZ.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

                // Set only the clicked button
                v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.button_pressed));
            }
        }));
    }