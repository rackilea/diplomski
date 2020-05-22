public static void simulateKey(final int KeyCode) {

    new Thread() {
        @Override
        public void run() {
            try {
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyCode);
            } catch (Exception e) {
                Log.e("Exception when sendKeyDownUpSync", e.toString());
            }
        }

    }.start();
}