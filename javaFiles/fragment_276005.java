textView.setText(text);
final int lineNumber = 20;
scroller.post(new Runnable() {
    @Override
    public void run() {
        int y = textView.getLayout().getLineTop(lineNumber);
        scroller.scrollTo(0, y);
    }
});