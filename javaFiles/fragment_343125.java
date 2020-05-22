...
super.onDraw(canvas);
int elapsedTime = (int)(SystemClock.elapsedRealtime() - startTime);
//elapsedTime is now the number of milliseconds that have elapsed since startTime.
drawGameBoard(canvas);

if((elapsedTime/6000)%2==0) {    //True for 0-5999, false for 6000-11999, true for 12000-17999, etc.
    if(cannon.paint.getColor()!=Color.BLUE) {
        cannon.paint.setColor(Color.BLUE);
        cannon.invalidate();
    }
}
else {
    if(cannon.paint.getColor()!=Color.RED) {
        cannon.paint.setColor(Color.RED);
        cannon.invalidate();
    }
}

invalidate();    //prompt a re-draw of this GameView (gameboard)
...