Vibrator mVibrator = (Vibrator) App.getInstance().getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {100, 1000, 100, 1000};
        if (mVibrator != null) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM) //key
                    .build();
            mVibrator.vibrate(pattern, 2, audioAttributes);
}