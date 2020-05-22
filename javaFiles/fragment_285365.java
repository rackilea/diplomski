radiusRangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
        @Override
        public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
            rangeBarValue = rightPinValue;
            // first remove the previous action if it exists
            handler.removeCallbacks(showDialogRunnable);
            // schedule a new action to take place in 700ms
            handler.postDelayed(showDialogRunnable, 700);
        }
    });