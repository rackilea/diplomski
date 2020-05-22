public void nextExpression() {
    i++;
    runOnUiThread(new Runnable() {
        public void run() {
            expression.setText("" + i);
        }
    });
}