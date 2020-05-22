public class MyActivity extends Activity {

    private Editable mEditable;

    private class MySpan implements LineBackgroundSpan {
        private final Rect rect = new Rect();
        private final Drawable drawable;
        private int next = 0;

        public MySpan(Drawable drawable) {
            this.drawable = drawable;
        }

        @Override
        public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline,
                int bottom, CharSequence text, int start, int end, int lnum) {
            if (start == end) return;
            if (next == 0) {
                next = mEditable.nextSpanTransition(start, Integer.MAX_VALUE, MySpan.class);
                rect.left = left;
                rect.top = top;
            }
            if (next == end) {
                rect.right = right;
                rect.bottom = bottom;
                c.save();
                drawable.setBounds(rect);
                drawable.draw(c);
                c.restore();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Resources res = getResources();
        final Drawable gd1 = res.getDrawable(R.drawable.gd1);
        final Drawable gd2 = res.getDrawable(R.drawable.gd2);
        final Drawable gd3 = res.getDrawable(R.drawable.gd3);
        final Drawable gd4 = res.getDrawable(R.drawable.gd4);

        final TextView tv = new TextView(this);
        setContentView(tv);

        tv.setText("Paragraphs with drawable background:\n", BufferType.EDITABLE);
        mEditable = tv.getEditableText();

        final String text = "paragraph text ";
        appendPara("###\n".replaceAll("#", text), gd1);
        appendPara("##############\n".replaceAll("#", text), gd2);
        appendPara("#######\n".replaceAll("#", text), gd3);
        appendPara("###########\n".replaceAll("#", text), gd4);
    }

    private void appendPara(String string, Drawable gd) {
        final int start = mEditable.length();
        mEditable.append(string);
        final int end = mEditable.length();
        mEditable.setSpan(new MySpan(gd), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

}