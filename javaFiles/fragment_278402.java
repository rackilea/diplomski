String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String t[] = {"A","B","C","D","E","F","G","H","I","J",
              "K","L","M","N","O","P","Q","R","S","T",
              "U","V","W","X","Y","Z"};
long fulltime=0;
double fullavetime=0;
long fullcount=0;   
long chartime=0;
double charavetime=0;
long charcount=0;
@Override
protected void onDraw(Canvas canvas) {
    float width = (float) getWidth();
    float inc=width/26;
    float y1 = (float) getHeight() / 3;
    float y2 = y1*2;;
    float x=0;

        // do this test loop 1000 times to get time data
    if (fullcount < 1000) {

        // test by char using a simple 26 char string
        // I tried to eliminate as much overhead as possible
        // so this just pulls strings from an array and draws them
    long start=System.currentTimeMillis();

    for (int i=0;i<26;i++) {
        canvas.drawText(t[i], x, y1, textPaint);
        x+=inc;
    }

    long end=System.currentTimeMillis();
    long elapse=end-start;
    chartime+=elapse;
    charcount++;
    charavetime=(double)chartime/charcount;

        // draw the entire 26 char string at once
    x=0f;
    start=System.currentTimeMillis();

    canvas.drawText(text, x, y2, textPaint);

    end=System.currentTimeMillis();
    elapse=end-start;
    fulltime+=elapse;
    fullcount++;
    fullavetime=(double)fulltime/fullcount;
    } else {
           // after the 1000 test draws, just paint the results on screen
        canvas.drawText("bychar "+charavetime, 0, y1, textPaint);
        canvas.drawText("  full "+fullavetime, 0, y2, textPaint);
    }
        // keep painting over and over
    invalidate();
}