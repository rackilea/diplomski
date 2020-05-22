long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
            long endTime = System.currentTimeMillis();

            long differenceTime = endTime - startTime;
            Log.d("TEST", String.format("%02d %02d",
                    TimeUnit.MILLISECONDS.toMinutes(differenceTime),
                    TimeUnit.MILLISECONDS.toSeconds(differenceTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(differenceTime))
            ));
        } catch (Exception e) {

        }