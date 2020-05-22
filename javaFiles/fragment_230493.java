public void aButton() {
        start = mediaPlayer.getCurrentPosition();

        if (aCount > 1 && bCount == 1) {
            aCount = 0;
            bCount = 0;
        }
        aCount += 1;

    }

    public void bButton() {
        stop = mediaPlayer.getCurrentPosition();

        if (bCount > 1 && aCount >= 1) {
            bCount = 0;
            aCount = 0;
        }

        if (aCount != 1) {
            Toast.makeText(this, "Please press A first", Toast.LENGTH_SHORT).show();
            bCount = 0;
        }
        if(bCount == 0 && aCount == 1){
            bCount += 1;
        }

        System.out.println("AB Button Count: " + bCount);
        /*mediaPlayer.seekTo(start);*/
        abLoopHandler.removeCallbacks(abLoop);
        abLoopHandler.postDelayed(abLoop, 100);
    }

    private Runnable abLoop = new Runnable() {
        @Override
        public void run() {
            if (aCount == 1 && bCount == 1) {
                int currPos = mediaPlayer.getCurrentPosition();
                if (currPos >= stop) {
                    mediaPlayer.seekTo(start);
                }
                abLoopHandler.postDelayed(this, 100);
            }
        }
    };