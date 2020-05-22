TextView textView = (TextView) findViewById(R.id.text);
textView.setMovementMethod(new ScrollingMovementMethod());
final int lineNumber = 20
textView.post(new Runnable() {
    @Override
    public void run() {
        int y = textView.getLayout().getLineTop(lineNumber);
        textView.scrollTo(0, y);
    }
});