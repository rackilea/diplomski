public class AutoResizeTextViewNoPadding extends TextView
{
(...)
        @Override
        public int onTestSize(final int suggestedSize,final RectF availableSPace)
        {
            paint.setTextSize(suggestedSize);
            final String text=getText().toString();
            final boolean singleline=getMaxLines()==1;
            if(singleline)
            {
                textRect.bottom=(float)(paint.getFontSpacing()*.8);
                textRect.right=paint.measureText(text);
            }
        (...)
        }

@Override
protected void onDraw(Canvas canvas) {
    int yOffset = getHeight() - getBaseline() - (int)super.getTextSize()/20;
    canvas.translate(0, 2*yOffset);
    super.onDraw(canvas);
}

}