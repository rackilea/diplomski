progressBar.setMax(75)
while (progressStatus < 75) {
    progressStatus += 1;
    // Update the progress bar and display the

    //current value in the text view
    handler.post(new Runnable() {
        public void run() {
            progressBar.setProgress(progressStatus);
            textView.setText(progressStatus+"/"+progressBar.getMax());
        }
    });
    try {
        // Sleep for 200 milliseconds.

        //Just to display the progress slowly
        Thread.sleep(200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}