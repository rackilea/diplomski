private final Runnable mRunnable = new Runnable() {
    public void run() {
        MyData myData;
        TextView textView;

        // if counters are active
        if (mCountersActive) {                
            if (mCounterList != null && mDataList != null) {
                for (int i=0; i < mDataList.size(); i++) {
                    myData = mDataList.get(i);
                    textView = mCounterList.get(i);
                    if (textView != null) {
                        if (myData.getCount() >= 0) {
                            textView.setText(myData.getCountAsString());
                            myData.reduceCount();
                        }
                    }
                }
            }
            // update every second
            mHandler.postDelayed(this, 1000);
        }
    }
};