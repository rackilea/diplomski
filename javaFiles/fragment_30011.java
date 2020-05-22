public void onTick(long millisUntilFinished) {
    final String days = .. // some code to generate days
    getActivity().runOnUiThread(new Runnable() {
        public void run() {
            tv.setText("Days left: " + days);
        }
    });
}

public void onFinish() {
    Log.i("countdown","CD Finished");
    getActivity().runOnUiThread(new Runnable() {
        public void run() {
            tv.setText("CD Finished!");
        }
    });
}