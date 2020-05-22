private TextPaint mTextPaint;

    private void init() {
    mTextPaint = new TextPaint(TextPaint.ANTI_ALIAS_FLAG);
    // You can tweak the appearance of the textpaint here
    mTextPaint.setTextAlign(Align.CENTER);
    mTextPaint.setColor(color);
    }

    @Override
    public void onDraw() {
    super.onDraw()
    // You can tweak the positioning of the text here
    canvas.drawText("2", 25, 25, mTextPaint);
    }