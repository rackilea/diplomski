public static void setText(final int idx,final String str) {
    UIHandler.post(new Runnable() {
        @Override
        public void run() {
            _textview[idx].setText(str);
        }
    });
}