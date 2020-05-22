private void ToastTime(long totalTime, long elapsedTime){
    final int remainInSec = (int)(totalTime - elapsedTime) / 1000;
    if(remainInSec>0) {
        final Activity activity = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, String.valueOf(remainInSec) + " seconds to enable button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

private void EnableButton(){
    Button button=findViewById(R.id.button);
    button.setEnabled(true);
}