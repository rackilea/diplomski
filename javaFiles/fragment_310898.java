new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                // handler has reached the time
                // now update the TextView using a runOnUiThread
                runOnUiThread(new Runnable() {
                public void run() {
                // Update UI elements

                // get the current time now
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) millis / 1000;
                int minutes = (int) seconds / 60;
                seconds %= 60;

                //finally update the TextView
                timerTextView.setText(minutes + ":" + seconds);

                   }
                });

                }
            }, randomTime);