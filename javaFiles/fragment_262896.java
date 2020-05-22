class YourClass extends View
{
    Rect middleRect;
    Paint ourBlue;
    Paint textPaint;

    public YourClass()
    {
         //constructor
         init();
    }

    private void init()
    {
        middleRect = new Rect();
        ourBlue; = new Paint();
        textPaint = new Paint();

        ourBlue.setColor(Color.BLUE);
        textPaint.setARGB(50,100,100,250);
        textPaint.setTextAlign(Align.CENTER);
        textPaint.setTextSize(50);
        textPaint.setTypeface(font);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        canvas.drawText("Logan is awesom",canvas.getWidth()/2,200,textPaint);
        canvas.drawBitmap(pBall, (canvas.getWidth()/2), changingY, null);
        if (changingY <canvas.getHeight()){
            changingY += 10;
        }else{
            changingY=0;
        }

        //if canvas size doesn't change - this can be moved to init() as well
        middleRect.set(0, 400, canvas.getWidth(), 550);

        canvas.drawRect(middleRect, ourBlue);
    }
}