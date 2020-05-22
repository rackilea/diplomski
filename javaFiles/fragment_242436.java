private Context context;
public Zaladuj(Context con)
{
    super()
    this.context = con
}

private void downloadResources() 
{
    //
      loading_screen = BitmapFactory.decodeResource(this.context.getResources(),R.drawable.loading_screen);
    //
    int count = 10;
    for (int i = 0; i < count; i++) 
    {
        try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
    }
}