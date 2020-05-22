milliseconds = (int) (appCurrentTime % 1000);

            String hours,
            minutes=String.format("%02d", mins),
            seconds=String.format("%02d", secs),
            miliSeconds=String.format("%03d", milliseconds);

            time.setText(minutes + ":" + seconds+ ":" + miliSeconds.substring(0,2) );