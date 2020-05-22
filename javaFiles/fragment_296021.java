ChainedCountDownTimer timer1 = new ChainedCountDownTimer(3 * 1000, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        Log.d(TAG, "timer1 onTick");
    }

    @Override
    public void onFinish() {
        Log.d(TAG, "timer1 onFinish");
    }
};

ChainedCountDownTimer timer2 = new ChainedCountDownTimer(30 * 1000, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        Log.d(TAG, "timer2 onTick");
    }

    @Override
    public void onFinish() {
        Log.d(TAG, "timer2 onFinish");
    }
};

timer1.setNext(timer2).start();