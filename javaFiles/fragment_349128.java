public void setValue(int value)
{
    _value = value;
    setOpacity((byte)255);
    invalidate();
}

@Override
protected void onDraw(Canvas canvas)
{
    canvas.drawRect(0,getHeight() - (int)((-110 - _value) * ycoeff * -1),size,getHeight(), pnt);
}