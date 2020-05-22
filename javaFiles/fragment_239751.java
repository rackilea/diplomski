public class Board extends ViewGroup{

Paint textPaint;
List<TextElement> words = new ArrayList<TextElement>();

public Board(Context context, AttributeSet attrs) {
//...
textPaint = new Paint();
//...
}

protected void onDraw(Canvas canvas) {
//...
int i = 0;
    for (TextElement element : words) {
        textSize = element.getSize() * scaleMap.get(i);
            if (inContact == i) {
               textPaint.setColor(Color.RED);
            } else {
               textPaint.setColor(element.getElementPaint().getColor());
            }
    textPaint.setTextSize(textSize);
    canvas.drawText(element.getText(), element.getX(), element.getY(),textPaint);
    i++;
    }
//...
}

public void addText(String newWord) {
    Paint newTextPaint = new Paint();
    newTextPaint.setTextAlign(Paint.Align.LEFT);
    newTextPaint.setTextSize(35);
    newTextPaint.setColor(Color.BLUE);
    TextElement newText = new TextElement(newWord, 35, newTextPaint, 10, 35);
    words.add(newText);
    scaleMap.add(words.size() - 1, 1.f);
    collisionMap.add(words.size() - 1, new RectF());
    }
}