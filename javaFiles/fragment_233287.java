public void someButtonClicked(params...) {
    new Thread(new Runnable() {
        public void run() {
            longOperation();
        }
    }).start();
}

public void longOperation() {
    for(int i=0; i<1000; i++) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // add new row to jtable
            }
        });
    }
}