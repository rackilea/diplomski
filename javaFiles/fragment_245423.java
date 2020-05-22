@Override
public void onDraw(Canvas canvas) {

    Paint paintBack = new Paint();
    paintBack.setStyle(Paint.Style.FILL);
    paintBack.setColor(Color.DKGRAY);

    List<Key> keys = getKeyboard().getKeys();
    for(Key key: keys) {
        Rect fillRect = new Rect();
        fillRect.left = key.x + keyMargin;
        fillRect.right = key.x + key.width - keyMargin;
        fillRect.top = key.y + keyMargin;
        fillRect.bottom = key.y + key.height - keyMargin;

        System.out.println("X: " + Integer.toString(key.x) + ", Y: " + Integer.toString(key.y) + ", W: " + Integer.toString(key.width) + ", H: " + Integer.toString(key.height));
        canvas.drawRect(fillRect, paintBack);
    }
}