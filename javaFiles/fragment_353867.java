public class MovementMethod extends LinkMovementMethod {

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();

            x += widget.getScrollX();
            y += widget.getScrollY();

            Layout layout = getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);

            int lineLength = line;
            String[] lines = getText().toString().split("\n");
            for (int i = 0; i <= line; i++) {
                lineLength += lines[i].length();
            }

            if (off >= lineLength) {
               // Return true so click won't be triggered in the leftover empty space
                return true;
            }
        }

        return super.onTouchEvent(widget, buffer, event);
    }
}