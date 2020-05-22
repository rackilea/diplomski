public void scroll(int scroll_to)
{
    final int x = scroll_to;
    final HorizontalScrollView scrl = (HorizontalScrollView)findViewById(R.id.horizontalScrollView1);
    scrl.post(new Runnable()
    {
        public void run()
        {
            scrl.scrollTo(0, x);
        } 
    });
}