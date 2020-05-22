class MyViewClass extends View
{

    ...
    private int mJ = 0;
    ...
    @Override
    protected void onDraw( Canvas canvas )
    {
        ...
        if(mJ <= 100)
        {
            canvas.drawText("miss", (float) chibi1.getX(), (float) chibi1.getY()-mJ, pt.pBlack);
            mJ++;
            invalidate();    //Prompt an immediate re-draw
        }
        ...
    }
    ...
}