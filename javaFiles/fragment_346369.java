public void testUI(){

    mainActivity.runOnUiThread(new Runnable() {

        @Override
        public void run() {
            editText.performClick();

        }
    });

    this.sendKeys(KeyEvent.KEYCODE_A);
    this.sendKeys(KeyEvent.KEYCODE_B);
    this.sendKeys(KeyEvent.KEYCODE_C);
    this.sendKeys(KeyEvent.KEYCODE_D);
    this.sendKeys(KeyEvent.KEYCODE_E);



    mainActivity.runOnUiThread(new Runnable() {

        @Override
        public void run() {
            button.performClick();

        }
    });
    getInstrumentation().waitForIdleSync();
}