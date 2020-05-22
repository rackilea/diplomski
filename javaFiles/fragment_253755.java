private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {
    disableButton1();
    final Thread t;
    if (flagState == 0) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    WavFile.decode(readWavFile, msg.getText(), key.getText().hashCode());
                } catch (WavFileException | IOException e) {
                    notes.setText(e.getMessage());
                }
            }
        });
    } else if (flagState == 1) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    WavFile.encode(readWavFile, msg.getText(), key.getText().hashCode()); 
                } catch (WavFileException | IOException e) {
                    notes.setText(e.getMessage());
                }
            }
        });
    }

    Thread monitor = new Thread(new Runnable() {
        public void run() {
            try {
                while (notComplete(t)) {
                    setProgressBar(getProgress(t));
                    Thread.sleep(SLEEP_TIME);
                }
                t.join();
            } finally {
                enableButton1();
            }
        }
    });

    t.start();
    monitor.start();
}