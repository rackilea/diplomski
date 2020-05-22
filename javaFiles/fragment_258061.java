Handler handler = new Handler();

// Then call (in a Thread):

handler.postDelayed(new Runnable()
{
    public void run()
    {
        label1.setText("b");
    }
}, 1000);