if (v.getId() == R.id.button_start) {
        SensorProcessor mSensorProcessor = ((MyApplication)getApplication()).getCurrentSensorProcessor();
        if (mSensorProcessor != null)
            mSensorProcessor.mActivity = this;
        else {
            runnable = new SensorProcessor(this.getApplicationContext(), this);
            thread = new Thread(runnable);
            thread.start();
        }
    }