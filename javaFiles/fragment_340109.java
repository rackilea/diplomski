private void test(List<Integer> resultTimeList, Integer count) {
    flash.setTorchMode(flash.getCameraIdList()[0], true);
    new CountDownTimer(resultTimeList.get(count), 500) {
        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
            new CountDownTimer(500, 500) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    flash.setTorchMode(flash.getCameraIdList()[0], false);
                    test(resultTimeList, count++);
                }
            }.start();

        }
    }.start();
}